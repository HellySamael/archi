package com.github.samael.storage.memory

import com.github.samael.business.core.Pet
import com.github.samael.storage.IPetStorage

class PetMemoryStorage:IPetStorage {

    private val petMemory: MutableMap<String,Pet>
    init {
        petMemory=HashMap()
    }
    override fun create(pet: Pet): Pet {
        petMemory[pet.id] = pet
        return Pet(pet.id,pet.name)
    }

    override fun get(id: String): Pet? {
        return petMemory[id]
    }

}