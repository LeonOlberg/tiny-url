package com.tiny_url.domain.services

interface IUrlShorter {
    suspend fun shortUrl(url: String): String

}