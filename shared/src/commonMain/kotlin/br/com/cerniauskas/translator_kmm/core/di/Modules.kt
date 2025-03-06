package br.com.cerniauskas.translator_kmm.core.di

import br.com.cerniauskas.bookpedia.core.data.HttpClientFactory
import br.com.cerniauskas.translator_kmm.translate.data.network.KtorRemoteTranslateClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModules = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteTranslateClient)
}