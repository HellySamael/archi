dependencies{
    implementation(project(":core"))
    api(project(":pet-storage"))
    testImplementation(project(":pet-storage","testArchive"))
}