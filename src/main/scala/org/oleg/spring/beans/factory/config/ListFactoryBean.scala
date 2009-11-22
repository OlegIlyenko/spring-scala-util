package org.oleg.spring.beans.factory.config

import org.springframework.beans.factory.config.AbstractFactoryBean

import java.util.{List => JList}
import reflect.BeanProperty
import collection._
import JavaConversions._
import mutable.ListBuffer

/**
 * Factory bean for immutable scala list
 *
 * @author Oleg Ilyenko
 */
class ListFactoryBean(@BeanProperty var sourceCollection: JList[Any]) extends AbstractFactoryBean[immutable.List[Any]] {

    def this() = this (null)

    def getObjectType = classOf[immutable.List[Any]]

    override def createInstance(): immutable.List[Any] = if (this.sourceCollection == null) {
        throw new IllegalArgumentException("'sourceCollection' is required");
    } else sourceCollection.toList

}