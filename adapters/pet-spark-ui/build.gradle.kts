dependencies{
    implementation(project(":core"))
    api(project(":pet-rest-ui"))
    implementation("com.sparkjava:spark-core:2.9.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    testImplementation(project(":pet-rest-ui","testArchive"))
}