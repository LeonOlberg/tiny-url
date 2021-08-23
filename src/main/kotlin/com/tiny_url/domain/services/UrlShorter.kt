package com.tiny_url.domain.services

import java.security.MessageDigest

class UrlShorter: IUrlShorter {
    override suspend fun shortUrl(url: String): String = hash(url)

    private fun hash(value: String): String {
        val bytes = value.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }

}