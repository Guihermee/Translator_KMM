package br.com.cerniauskas.translator_kmm.translate.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TranslatedDto(
    val translatedText: String
)
