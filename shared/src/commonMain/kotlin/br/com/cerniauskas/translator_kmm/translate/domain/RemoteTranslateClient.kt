package br.com.cerniauskas.translator_kmm.translate.domain

import br.com.cerniauskas.translator_kmm.core.domain.language.Language

interface RemoteTranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}