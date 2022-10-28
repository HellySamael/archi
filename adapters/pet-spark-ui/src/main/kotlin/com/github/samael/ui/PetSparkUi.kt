package com.github.samael.ui


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.*
import com.github.samael.business.IPetDomain
import com.github.samael.business.core.Pet

import com.github.samael.ui.IPetUi
import com.github.samael.ui.SingletonEnvironmentContext
import spark.Spark.*

class PetSparkUi : IPetUi<Any> {


    private val objectMapper: ObjectMapper
    init {
        this.objectMapper  = jacksonObjectMapper()
    }

    fun start(){
        println("will start spark")
        port(8080)
        post("/pet") { req, res ->
            println("rentre")
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