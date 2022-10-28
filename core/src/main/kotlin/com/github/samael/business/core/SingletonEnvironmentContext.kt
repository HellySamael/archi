package com.github.samael.business.core

import com.github.samael.business.IPetDomain


class SingletonEnvironmentContext{

    companion object{
        lateinit var PET_DOMAIN: IPetDomain

        fun getPetDomain():IPetDomain{
            return PET_DOMAIN
        }

        fun setPetDomain(petDomain: IPetDomain){
            PET_DOMAIN =petDomain
        }
    }




}