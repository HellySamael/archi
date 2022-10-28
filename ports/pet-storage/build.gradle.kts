dependencies{
    implementation(project(":core"))
}

configurations.register(
    "testArchive"
){
    extendsFrom(configurations.testImplementation.get())
}
tasks.register<Jar>(
    name = "jarTest"
){
    from(project.sourceSets.test.get().output)
    description= "create a jar from the source set"
    archiveClassifier.set("test")
}

artifacts {
    add("testArchive",tasks.getByName("jarTest"))
}
