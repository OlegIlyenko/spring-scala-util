package org.oleg.spring.beans.factory.xml

import org.springframework.beans.factory.support.BeanDefinitionBuilder

import org.w3c.dom.Element
import org.oleg.spring.beans.factory.config.ListFactoryBean
import org.springframework.beans.factory.xml.ParserContext

/**
 * Bean definition parser for the immutable lists
 *
 * @author Oleg Ilyenko
 */
class ListBeanDefinitionParser extends CollectionBeanDefinitionParser {

    override def getBeanClass(element: Element) = classOf[ListFactoryBean]

    def getOriginalList(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) =
        parserContext.getDelegate.parseListElement(element, builder.getRawBeanDefinition)
}