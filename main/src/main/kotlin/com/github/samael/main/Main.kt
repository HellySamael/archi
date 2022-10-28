package com.github.samael.main

import com.github.samael.business.PetDomain
import com.github.samael.storage.memory.PetMemoryStorage
import com.github.samael.ui.PetSparkUi
import com.github.samael.ui.SingletonEnvironmentContext
import com.github.samael.ui.controller.PetSpringController


fun main() {
        val petMemoryStorage = PetMemoryStorage()
        val petDomain = PetDomain(petMemoryStorage)
        val petUi = PetSparkUi()
        SingletonEnvironmentContext.setPetDomain(petDomain)
        petUi.start()


}
