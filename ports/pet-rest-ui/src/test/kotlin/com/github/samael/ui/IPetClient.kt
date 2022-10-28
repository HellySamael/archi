package com.github.samael.ui

import com.github.samael.business.core.Pet
import feign.Headers
import feign.RequestLine
import feign.Response


interface IPetClient {
        @RequestLine("POST /hello")
        @Headers("Content-Type: application/json")
        fun create(pet: Pet): Response
}