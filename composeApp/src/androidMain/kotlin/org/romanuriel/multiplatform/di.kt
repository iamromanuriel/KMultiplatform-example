package org.romanuriel.multiplatform

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.romanuriel.multiplatform.di.dataModule
import org.romanuriel.multiplatform.di.networkClientModule
import org.romanuriel.multiplatform.di.repositoryModule
import org.romanuriel.multiplatform.ui.screen.character.CharacterViewModel
import org.romanuriel.multiplatform.ui.screen.home.HomeViewModel


val viewModelModule = module{
    viewModelOf( ::HomeViewModel)
    viewModel { (id: Int) ->
        CharacterViewModel(get(), id)
    }
}

fun initKoin(config: KoinAppDeclaration ? = null){
    startKoin {
        config?.invoke(this)
        modules(dataModule, networkClientModule, repositoryModule, viewModelModule)
    }
}