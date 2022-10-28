package com.github.samael.ui

import com.github.samael.business.IPetDomain


class SingletonEnvironmentContext{

    companion object{
        lateinit var PET_DOMAIN: IPetDomain

        fun getPetDomain():IPetDomain{
            return PET_DOMAIN
        }

        fun setPetDomain(petDomain: IPetDomain){
            SingletonEnvironmentContext.PET_DOMAIN=petDomain
        }
    }




}