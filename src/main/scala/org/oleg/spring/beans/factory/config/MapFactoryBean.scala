package org.oleg.spring.beans.factory.config

import org.springframework.beans.factory.config.AbstractFactoryBean

import java.util.{Map => JMap}
import reflect.BeanProperty
import collection._
import JavaConversions._
import mutable.MapBuilder

/**
 * Factory bean for scala map
 *
 * @author Oleg Ilyenko
 */
class MapFactoryBean(
    @BeanProperty var sourceCollection: JMap[Any, Any],
    @BeanProperty var mutability: Mutability.Value = Mutability.immutable
) extends AbstractFactoryBean[Map[Any, Any]] {

    def this() = this (null)

    def getObjectType: Class[_ <: Map[Any, Any]] = mutability match {
        case Mutability.mutable => classOf[mutable.Map[Any, Any]]
        case Mutability.immutable => classOf[immutable.Map[Any, Any]]
    }

    override def createInstance(): Map[Any, Any] = if (this.sourceCollection == null) {
        throw new IllegalArgumentException("'sourceCollection' is required");
    } else mutability match {
        case Mutability.mutable => sourceCollection
        case Mutability.immutable =>
            val builder = new MapBuilder[Any, Any, immutable.Map[Any, Any]](immutable.Map.empty)
            sourceCollection.foreach(keyValue => builder += (keyValue._1 -> keyValue._2))
            builder.result
    }

}