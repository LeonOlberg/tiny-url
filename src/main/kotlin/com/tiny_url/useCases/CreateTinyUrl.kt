package ceom.tiny_url.useCases

import com.tiny_url.adapters.controller.model.TinyUrlModel
import com.tiny_url.domain.TinyUrl
import com.tiny_url.domain.services.IUrlShorter
import com.tiny_url.domain.services.UrlShorter

class CreateTinyUrl(private val urlShorter: IUrlShorter = UrlShorter()) {
    suspend fun execute(tinyUrl: TinyUrlModel): String {
        val shortedUrl = urlShorter.shortUrl(tinyUrl.originalUrl)
        val tinyUrlEntity = TinyUrl(originalUrl = tinyUrl.originalUrl, shortUrl = shortedUrl)

        return tinyUrlEntity.shortUrl
    }
}