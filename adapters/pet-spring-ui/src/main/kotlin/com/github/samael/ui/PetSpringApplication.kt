package com.github.samael.ui

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary


@SpringBootApplication
open class PetSpringApplication() {

}

@Bean
@Primary
fun objectMapper(): ObjectMapper? {
    return jacksonObjectMapper()
}
