package com.thindie.model

/**
 *  Just payed your attention
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class NotExpectedSideEffectInside(val message: String = "")
