package com.github.samael.ui


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.*
import com.github.samael.business.core.Pet

import com.github.samael.business.core.SingletonEnvironmentContext
import spark.Spark.*

class PetSparkUi : IPetUi<Any> {

    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    fun start(){
        port(8080)
        post("/pet") { req, res ->
                val body:String = req.body()
                val petRequest: Pet = objectMapper.readValue(body)
                val petCreated = this.create(petRequest)
                res.status(200)
                objectMapper.writeValueAsString(petCreated)
        }
    }

    override fun create(pet: Pet):Pet {
        val petDomain = SingletonEnvironmentContext.getPetDomain()
        return petDomain.create(pet)
    }

}