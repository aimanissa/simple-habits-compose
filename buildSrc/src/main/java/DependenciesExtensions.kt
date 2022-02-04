import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import java.lang.IllegalArgumentException

// util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(vararg elements: String) {
    elements.forEach { dependency ->
        add("kapt", dependency)
    }
}

@Deprecated("Use kapt(vararg) method instead")
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.kaptTest(list: List<String>) {
    list.forEach { dependency ->
        add("kaptTest", dependency)
    }
}

fun DependencyHandler.kaptAndroidTest(list: List<String>) {
    list.forEach { dependency ->
        add("kaptAndroidTest", dependency)
    }
}

fun DependencyHandler.implementation(vararg elements: ProjectDependency) {
    implementationInternal(listOf(*elements))
}

fun DependencyHandler.implementation(vararg elements: String) {
    implementationInternal(listOf(*elements))
}

@Deprecated("Use implementation(vararg) method instead")
fun <T> DependencyHandler.implementation(list: List<T>) {
    implementationInternal(list)
}

fun DependencyHandler.androidTestImplementation(vararg elements: String) {
    elements.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

@Deprecated("Use androidTestImplementation(vararg) method instead")
fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

private fun <T> DependencyHandler.implementationInternal(list: List<T>) {
    list.forEach { dependency ->
        when (dependency) {
            is ProjectDependency -> add("implementation", dependency)
            is String -> add("implementation", dependency)
            else -> throw IllegalArgumentException("Unsupported type: ${dependency!!::class.java}")
        }
    }
}

