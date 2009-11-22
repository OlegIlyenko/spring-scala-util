package org.angelsmasterpiece.spring.scala.bean

import collection._
import reflect.BeanInfo

import java.util.{List => JList}
import javax.annotation.PostConstruct

/**
 * Just simple bean for testing
 *
 * @author Oleg Ilyenko
 */
@BeanInfo
class SampleBean(
    var javaStringList: JList[String] = null,
    var scalaStringList: immutable.List[String] = null,
    var scalaStringSeq: immutable.Seq[String] = null,
    var scalaStringSeq1: immutable.Seq[String] = null,

    var scalaStringBuffer: mutable.Buffer[String] = null,

    var scalaMutableSet: mutable.Set[String] = null,
    var scalaImmutableSet: immutable.Set[String] = null,

    var scalaMutableMap: mutable.Map[String, String] = null,
    var scalaImmutableMap: immutable.Map[String, String] = null
) {

    def this() = this (null)

    @PostConstruct
    def init() {
        println("Java list: " + javaStringList)
        println("Scala list: " + scalaStringList)
        println("Scala buffer: " + scalaStringSeq)
        println("Scala seq: " + scalaStringSeq)

        println("Scala mutable set: " + scalaMutableSet)
        println("Scala immutable set: " + scalaImmutableSet)
        
        println("Scala mutable map: " + scalaMutableMap)
        println("Scala immutable map: " + scalaImmutableMap)
    }

}