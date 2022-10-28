package com.github.samael.storage

import com.github.samael.business.core.Pet

interface IPetStorage {
  fun create(pet:Pet): Pet
  fun get(id: String): Pet
}