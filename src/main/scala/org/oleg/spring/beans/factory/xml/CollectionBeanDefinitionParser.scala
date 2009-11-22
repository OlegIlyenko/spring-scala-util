package org.oleg.spring.beans.factory.xml

import org.oleg.scala.pattern.NotEmptyString
import org.springframework.beans.factory.config.RuntimeBeanReference

import NotEmptyString._
import org.w3c.dom.Element
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.beans.factory.xml.{ParserContext, AbstractSingleBeanDefinitionParser}
import UtilNamespaceHandler._
import org.oleg.spring.beans.factory.config._

/**
 * Base bean definition parser for scala collections (lists, sets and maps)
 * 
 * @author Oleg Ilyenko
 */
abstract class CollectionBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    override def doParse(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) {
        val originalCollection =  element getAttribute  REF_ATTRIBUTE match  {
            case NotEmptyString(ref) => new RuntimeBeanReference(ref)
            case _ => getOriginalList(element, parserContext, builder)
        }

        builder addPropertyValue ("sourceCollection", originalCollection);

        val mutability = element getAttribute  MUTABILITY_ATTRIBUTE;
        if (notEmptyString(mutability)) builder addPropertyValue ("mutability",  Mutability withName mutability)

        val scope = element getAttribute  SCOPE_ATTRIBUTE;
        if (notEmptyString(scope)) builder setScope scope
    }

    /**
     * Method should return correspondent collection taken from the body of XML collection definition
     *
     * @param element the XML element being parsed
	 * @param parserContext the object encapsulating the current state of the parsing process
	 * @param builder used to define the <code>BeanDefinition</code>
     */
    def getOriginalList(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder): Any
}