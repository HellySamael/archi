dependencies{
    api(project(":core"))
    file("../ports").listFiles()?.forEach {
        api(project(":${it.name}"))
    }
}