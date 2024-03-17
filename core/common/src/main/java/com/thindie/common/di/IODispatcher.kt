package com.thindie.common.di

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY
)
annotation class IODispatcher
