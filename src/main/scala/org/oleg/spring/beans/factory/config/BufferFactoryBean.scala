package org.oleg.spring.beans.factory.config

import org.springframework.beans.factory.config.AbstractFactoryBean

import java.util.{List => JList}
import reflect.BeanProperty
import collection._
import  JavaConversions._

/**
 * Factory bean for mutable scala Buffer
 *
 * @author Oleg Ilyenko
 */
class BufferFactoryBean(@BeanProperty var sourceCollection: JList[Any]) extends AbstractFactoryBean[mutable.Buffer[Any]] {

    def this() = this (null)

    def getObjectType = classOf[mutable.Buffer[Any]]

    override def createInstance(): mutable.Buffer[Any] = if (this.sourceCollection == null) {
        throw new IllegalArgumentException("'sourceCollection' is required");
    } else sourceCollection

}