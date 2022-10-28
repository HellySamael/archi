package com.github.samael.ui

import com.github.samael.business.IPetDomain

class PetSparkUiTest():APetUiTest<Any>() {
    override fun getSUT(petDomain: IPetDomain): IPetUi<Any> {
        SingletonEnvironmentContext.setPetDomain(petDomain)
        val petSparkUi = PetSparkUi()
        petSparkUi.start()
        return petSparkUi
    }
}