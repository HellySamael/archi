package com.github.samael.ui

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.samael.business.IPetDomain
import com.github.samael.business.core.Pet
import feign.Feign
import feign.Logger
import feign.Response
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.io.InputStream


abstract class APetUiTest<T> {

    abstract fun getSUT(petDomain: IPetDomain): IPetUi<T>

    val mockDomain:IPetDomain = mock()
    lateinit var petClient:IPetClient




    private lateinit var pet: Pet
    private lateinit var response:Response
    @Before
    fun beforeTests(){
        getSUT(mockDomain)
        petClient = Feign.builder().encoder(JacksonEncoder()).decoder(JacksonDecoder()).target(IPetClient::class.java, "http://localhost:8080")
    }

    private fun givenPetRequest() {
        pet = Pet("123", "test")
    }

    private fun givenPetReturnOnCreate() {
        doReturn(pet).`when`(mockDomain).create(any())
    }

    private fun whenCallCreate() {
        response= petClient.create(pet)

    }

    private fun thenResponseShouldBeOk() {
        assertThat(response.status()).isEqualTo(200)
    }

    private fun thenResponseShouldContainerPet(){
        val jacksonObjectMapper:ObjectMapper = jacksonObjectMapper()
        val body:InputStream = response.body().asInputStream()
        val petCreated:Pet = jacksonObjectMapper.readValue(body)
        assertThat(petCreated).isEqualTo(pet)
    }
    @Test
    open fun should_send_request() {
        givenPetRequest()
        givenPetReturnOnCreate()
        whenCallCreate()
        thenResponseShouldBeOk()
        thenResponseShouldContainerPet()
    }









}