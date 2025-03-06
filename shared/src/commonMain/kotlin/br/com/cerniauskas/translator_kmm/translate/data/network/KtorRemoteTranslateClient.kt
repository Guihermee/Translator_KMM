package br.com.cerniauskas.translator_kmm.translate.data.network

import br.com.cerniauskas.translator_kmm.core.data.safeCall
import br.com.cerniauskas.translator_kmm.core.domain.language.Language
import br.com.cerniauskas.translator_kmm.core.domain.map
import br.com.cerniauskas.translator_kmm.translate.data.dto.TranslateDto
import br.com.cerniauskas.translator_kmm.translate.data.dto.TranslatedDto
import br.com.cerniauskas.translator_kmm.translate.domain.RemoteTranslateClient
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class KtorRemoteTranslateClient(
    private val httpClient: HttpClient
): RemoteTranslateClient {

    val baseUrl = "https://translate.pl-coding.com"

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        return safeCall<TranslatedDto> {
            httpClient.post {
                url("$baseUrl/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        }.map { it.translatedText }.toString()
    }

}