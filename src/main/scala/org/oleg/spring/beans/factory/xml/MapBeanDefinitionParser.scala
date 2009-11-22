package org.oleg.spring.beans.factory.xml

import org.oleg.spring.beans.factory.config.MapFactoryBean
import org.springframework.beans.factory.support.BeanDefinitionBuilder

import org.w3c.dom.Element
import org.springframework.beans.factory.xml.{ParserContext}

/**
 * Bean definition parser for the mutable and immutable maps
 *
 * @author Oleg Ilyenko
 */
class MapBeanDefinitionParser extends CollectionBeanDefinitionParser {

    override def getBeanClass(element: Element) = classOf[MapFactoryBean]

    def getOriginalList(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) =
        parserContext.getDelegate.parseMapElement(element, builder.getRawBeanDefinition)
}