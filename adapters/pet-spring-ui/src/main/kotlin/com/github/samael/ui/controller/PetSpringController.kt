package com.github.samael.ui.controller

import com.github.samael.business.IPetDomain
import com.github.samael.business.core.Pet
import com.github.samael.ui.IPetUi
import com.github.samael.ui.PetSpringApplication
import com.github.samael.ui.SingletonEnvironmentContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class PetSpringController : IPetUi<ResponseEntity<Any>> {

    fun start() {
        runApplication<PetSpringApplication>()
    }

    @PostMapping("/hello")
    override fun create(@RequestBody pet: Pet): ResponseEntity<Any> {
        val petDomain = SingletonEnvironmentContext.getPetDomain()
        val petCreated = petDomain.create(pet)
        return ResponseEntity<Any>(petCreated, HttpStatus.OK)
    }


}