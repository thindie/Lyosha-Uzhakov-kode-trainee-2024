plugins {
    id(Plugins.pureKotlin)
    id(Plugins.kapt)
}

dependencies {
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.annotationProcessorCompiler)
    testImplementation(Dependencies.Testing.junit)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Gson.gson)
    implementation(Dependencies.Gson.gsonConverter)
}