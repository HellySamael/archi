package com.github.samael.ui

import com.github.samael.business.IPetDomain
import com.github.samael.business.core.Pet
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.kotlin.mock

abstract class APetUiTest<T> {

    abstract fun getSUT(petDomain: IPetDomain): IPetUi<T>

    val mockDomain:IPetDomain = mock()


    fun getSUT(): IPetUi<T> {
        return getSUT(mockDomain)
    }

    private lateinit var pet: Pet

    @Test
    open fun should_test() {
        givenPetRequest()
        whenCallCreate()
        thenResponseShouldBeOk()
    }

    private fun thenResponseShouldBeOk() {
        assertThat(true).isTrue()
    }

    private fun givenPetRequest() {
        pet = Pet("123", "test")
    }

    private fun whenCallCreate() {
        getSUT().create(pet)

    }
}