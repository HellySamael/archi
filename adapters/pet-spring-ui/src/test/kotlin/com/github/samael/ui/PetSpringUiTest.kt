package com.github.samael.ui

import com.github.samael.business.IPetDomain
import com.github.samael.business.core.SingletonEnvironmentContext
import com.github.samael.ui.controller.PetSpringController
import org.springframework.http.ResponseEntity

class PetSpringUiTest:APetUiTest<ResponseEntity<Any>>() {
    override fun getSUT(petDomain: IPetDomain): IPetUi<ResponseEntity<Any>> {
        SingletonEnvironmentContext.setPetDomain(petDomain)
        val petSpringController = PetSpringController()
        petSpringController.start()
        return petSpringController
    }
}