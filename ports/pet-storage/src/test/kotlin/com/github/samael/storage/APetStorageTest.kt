package com.github.samael.storage

import com.github.samael.business.core.Pet
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

abstract class APetStorageTest {

    abstract fun getSUT(): IPetStorage

    private  var pet: Pet?=null
    private lateinit var petId: String
    private var petRetrieve: Pet? = null
    private fun givenPet() {
        pet = Pet("123", "test")
    }

    private fun givenCreatedPet() {
        pet?.let { getSUT().create(it) }
        petId = pet?.id ?: ""
    }

    private fun givenPetId() {
        petId = "DUMMY"
    }

    private fun whenGetPet() {
        petRetrieve = pet?.let { getSUT().get(it.id) }
    }

    private fun thenPetShouldBeTheSame() {
        assertThat(petRetrieve).isEqualTo(pet)
    }

    private fun thenPetShouldBeNull() {
        assertThat(petRetrieve).isNull()
    }

    @Test
    fun should_create_pet_and_retrieve_it() {
        givenPet()
        givenCreatedPet()
        whenGetPet()
        thenPetShouldBeTheSame()
    }

    @Test
    fun should_return_empty_pet_when_pet_does_not_exists() {
        givenPetId()
        whenGetPet()
        thenPetShouldBeNull()
    }
}