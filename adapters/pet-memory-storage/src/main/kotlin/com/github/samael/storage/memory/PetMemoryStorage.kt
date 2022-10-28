package com.github.samael.storage.memory

import com.github.samael.business.core.Pet
import com.github.samael.storage.IPetStorage

class PetMemoryStorage:IPetStorage {
    override fun create(pet: Pet): Pet {
        return Pet(pet.id,pet.name)
    }

    override fun get(id: String): Pet {
        TODO("Not yet implemented")
    }

}