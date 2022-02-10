dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "SimpleHabits"
include(":app")
include(":common")
include(":feature-home")
include(":feature-new-habits")
include(":data")
include(":domain")
