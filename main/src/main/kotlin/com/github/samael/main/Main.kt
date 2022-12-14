package com.github.samael.main

import com.github.samael.business.PetDomain
import com.github.samael.storage.memory.PetMemoryStorage
import com.github.samael.ui.PetSparkUi
import com.github.samael.business.core.SingletonEnvironmentContext


fun main() {
        val petMemoryStorage = PetMemoryStorage()
        val petDomain = PetDomain(petMemoryStorage)
        val petUi = PetSparkUi()
        SingletonEnvironmentContext.setPetDomain(petDomain)
        petUi.start()


}
