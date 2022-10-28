
repositories {
    mavenCentral()
}


dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    implementation(project(":core"))
    api(project(":pet-ui"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.1")
}