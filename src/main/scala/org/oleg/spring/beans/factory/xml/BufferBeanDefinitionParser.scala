package org.oleg.spring.beans.factory.xml

import org.springframework.beans.factory.support.BeanDefinitionBuilder

import org.w3c.dom.Element
import org.springframework.beans.factory.xml.{ParserContext}

import org.oleg.spring.beans.factory.config.BufferFactoryBean

/**
 * Bean definition parser for the mutable buffers
 *
 * @author Oleg Ilyenko
 */
class BufferBeanDefinitionParser extends CollectionBeanDefinitionParser {

    override def getBeanClass(element: Element) = classOf[BufferFactoryBean]

    def getOriginalList(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) =
        parserContext.getDelegate.parseListElement(element, builder.getRawBeanDefinition)
}