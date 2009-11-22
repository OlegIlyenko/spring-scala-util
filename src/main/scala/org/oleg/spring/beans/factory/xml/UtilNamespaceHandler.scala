package org.oleg.spring.beans.factory.xml

import org.springframework.beans.factory.xml.NamespaceHandlerSupport

/**
 * Handler for the <code>scala:util</code> namespace
 * 
 * @author Oleg Ilyenko
 */
class UtilNamespaceHandler extends NamespaceHandlerSupport {
    
	def init {
		registerBeanDefinitionParser("list", new ListBeanDefinitionParser());
		registerBeanDefinitionParser("buffer", new BufferBeanDefinitionParser());
		registerBeanDefinitionParser("set", new SetBeanDefinitionParser());
		registerBeanDefinitionParser("map", new MapBeanDefinitionParser());
	}
}

object UtilNamespaceHandler {

    val SCOPE_ATTRIBUTE = "scope";

    val REF_ATTRIBUTE = "ref";

    val MUTABILITY_ATTRIBUTE = "mutability";

}