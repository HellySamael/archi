dependencies{
    implementation(project(":core"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
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
