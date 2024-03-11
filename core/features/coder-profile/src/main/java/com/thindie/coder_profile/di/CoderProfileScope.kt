package com.thindie.coder_profile.di

import javax.inject.Scope

@Retention(AnnotationRetention.RUNTIME)
@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CoderProfileScope()
