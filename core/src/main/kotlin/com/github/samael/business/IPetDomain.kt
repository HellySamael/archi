package com.github.samael.business

import com.github.samael.business.core.Pet

interface IPetDomain {
    fun create(pet: Pet):Pet
}