plugins{
    application
}

dependencies{
    implementation(project(":core"))
    implementation(project(":business"))
    file("../adapters").listFiles()?.forEach {
        implementation(project(":${it.name}"))
    }
    file("../ports").listFiles()?.forEach {
        api(project(":${it.name}"))
    }
}

application {
    mainClass.set("com.github.samael.main.MainKt")
}