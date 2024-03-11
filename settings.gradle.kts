pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lyosha-Uzhakov-kode-trainee-2024"
include(":app")
include(":core:common")
include(":core:network")
include(":core:design-system")
include(":features:coders")
include(":features:coder-profile")

 