package com.tiny_url.domain

import java.util.*

data class TinyUrl(val id: UUID = UUID.randomUUID(), val originalUrl: String, val shortUrl: String)