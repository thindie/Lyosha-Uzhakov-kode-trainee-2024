package com.thindie.coders.di

import javax.inject.Scope

@Retention(AnnotationRetention.RUNTIME)
@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CodersMainScope()
