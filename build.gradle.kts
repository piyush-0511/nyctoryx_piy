allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
subprojects {
    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
            force("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")
            force("org.jetbrains.kotlin:kotlin-stdlib-common:1.9.0")
            force("androidx.lifecycle:lifecycle-common:2.7.0")
            force("androidx.lifecycle:lifecycle-runtime:2.7.0")
            force("androidx.annotation:annotation:1.8.0")
            force("androidx.tracing:tracing:1.2.0")
            force("androidx.core:core:1.13.1")
            force("androidx.arch.core:core-common:2.2.0")
            force("androidx.profileinstaller:profileinstaller:1.3.1")
            force("androidx.collection:collection:1.1.0")
            force("androidx.lifecycle:lifecycle-livedata-core:2.7.0")
            force("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
            force("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")
            force("androidx.core:core-ktx:1.13.1")
            force("androidx.concurrent:concurrent-futures:1.1.0")
            force("androidx.lifecycle:lifecycle-livedata:2.7.0")
            force("org.jetbrains:annotations:23.0.0")

        }
    }
}

