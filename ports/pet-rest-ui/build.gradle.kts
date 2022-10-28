dependencies{
    implementation(project(":core"))
    testImplementation("io.github.openfeign:feign-core:11.10")
    testImplementation("io.github.openfeign:feign-jackson:11.10")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")

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
