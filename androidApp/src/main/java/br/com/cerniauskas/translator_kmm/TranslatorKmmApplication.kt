package br.com.cerniauskas.translator_kmm

import android.app.Application
import br.com.cerniauskas.translator_kmm.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class TranslatorKmmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TranslatorKmmApplication)
        }
    }
}