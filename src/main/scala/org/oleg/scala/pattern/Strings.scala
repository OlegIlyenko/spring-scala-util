package org.oleg.scala.pattern {

    /**
     * Extractor for empty strings. Can be used in pattern matching.
     *
     * @author Oleg Ilyenko
     */
    object EmptyString {

        def unapply(s: String): Option[String] = if (s == null || s.trim == "") Some(s) else None

        def emptyString(str:String) = str match {
            case EmptyString(_) => true
            case _ => false
        }
    }

    /**
     * Extractor for non-empty strings. Can be used in pattern matching.
     *
     * @author Oleg Ilyenko
     */
    object NotEmptyString {

        def unapply(s: String): Option[String] = if (s != null && s.trim != "") Some(s) else None

        def notEmptyString(str:String) = str match {
            case NotEmptyString(_) => true
            case _ => false
        }
    }

}

