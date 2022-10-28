package com.github.samael.storage.memory

import com.github.samael.business.core.Pet
import com.github.samael.storage.APetStorageTest
import com.github.samael.storage.IPetStorage

class PetMemoryStorageTest: APetStorageTest() {

    private val petMemoryStorage:PetMemoryStorage = PetMemoryStorage()
    override fun getSUT(): IPetStorage {
        return petMemoryStorage
    }
}