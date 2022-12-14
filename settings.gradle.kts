/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.5.1/userguide/multi_project_builds.html
 */

rootProject.name = "archi"
include("core")
include("business")
include("main")
file("ports").listFiles()?.forEach {
    include(it.name)
    project(":${it.name}").projectDir = it
}
file("adapters").listFiles()?.forEach {
    include(it.name)
    project(":${it.name}").projectDir = it
}
