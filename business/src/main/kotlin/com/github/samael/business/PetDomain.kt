package com.github.samael.business

import com.github.samael.business.core.Pet
import com.github.samael.storage.IPetStorage


class PetDomain(petStorage: IPetStorage):IPetDomain{
    private val petStorage:IPetStorage
    init {
        this.petStorage = petStorage
    }
    override fun create(pet: Pet): Pet {
        val petCreated = petStorage.create(pet)
        return petCreated
    }

}