package com.github.samael.ui

import com.github.samael.business.core.Pet


interface IPetUi<T>{
    fun create(pet: Pet): T
}