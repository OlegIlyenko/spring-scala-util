package org.oleg.spring.beans.factory.xml

import org.springframework.beans.factory.support.BeanDefinitionBuilder

import org.w3c.dom.Element
import org.springframework.beans.factory.xml.{ParserContext}

import org.oleg.spring.beans.factory.config.SetFactoryBean

/**
 * Bean definition parser for the mutable and immutable sets
 *
 * @author Oleg Ilyenko
 */
class SetBeanDefinitionParser extends CollectionBeanDefinitionParser {

    override def getBeanClass(element: Element) = classOf[SetFactoryBean]

    def getOriginalList(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) =
        parserContext.getDelegate.parseSetElement(element, builder.getRawBeanDefinition)
}