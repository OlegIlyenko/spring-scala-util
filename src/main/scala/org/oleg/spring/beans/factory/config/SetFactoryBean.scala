package org.oleg.spring.beans.factory.config

import org.springframework.beans.factory.config.AbstractFactoryBean

import java.util.{Set  => JSet}
import reflect.BeanProperty
import collection._
import JavaConversions._

/**
 * Factory bean for scala set
 *
 * @author Oleg Ilyenko
 */
class SetFactoryBean(
    @BeanProperty var sourceCollection: JSet[Any],
    @BeanProperty var mutability: Mutability.Value = Mutability.immutable
) extends AbstractFactoryBean[Set[Any]] {

    def this() = this (null)

    def getObjectType: Class[_ <: Set[Any]] = mutability match {
        case Mutability.mutable => classOf[mutable.Set[Any]]
        case Mutability.immutable => classOf[immutable.Set[Any]]
    }

    override def createInstance(): Set[Any] = if (this.sourceCollection == null) {
        throw new IllegalArgumentException("'sourceCollection' is required");
    } else mutability match {
        case Mutability.mutable => sourceCollection
        case Mutability.immutable => sourceCollection.toSet
    }

}