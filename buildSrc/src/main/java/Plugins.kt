import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidApplicationVersion = "8.1.0"

    const val androidLibrary = "com.android.library"
    const val androidLibraryVersion = "8.1.0"

    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "org.jetbrains.kotlin.kapt"
    const val kotlinAndroidVersion = "1.9.0"

    const val kaptVersion = kotlinAndroidVersion
    const val kapt = "kotlin-kapt"

    const val pureKotlin = "org.jetbrains.kotlin.jvm"
    const val pureKotlinVersion = kotlinAndroidVersion
}