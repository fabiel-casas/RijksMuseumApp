package fabiel.casas.rijksmuseumapp.app

import androidx.paging.PagingSource
import fabiel.casas.rijksmuseumapp.data.datasource.RijksCollectionPagingSource
import fabiel.casas.rijksmuseumapp.data.datasource.RijksMuseumDataSource
import fabiel.casas.rijksmuseumapp.data.datasource.RijksMuseumDataSourceImpl
import fabiel.casas.rijksmuseumapp.data.networking.RetrofitConfiguration
import fabiel.casas.rijksmuseumapp.data.networking.RijksMuseumApi
import fabiel.casas.rijksmuseumapp.data.networking.response.ArtObject
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionViewModel
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCase
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */

val appModule = module {
    factory<RijksMuseumApi> {
        RetrofitConfiguration.build().create(RijksMuseumApi::class.java)
    }
    factory<RijksMuseumDataSource> {
        RijksMuseumDataSourceImpl(get())
    }
    factory<PagingSource<Int, ArtObject>> {
        RijksCollectionPagingSource(get())
    }
    factory<RijksMuseumUseCase> {
        RijksMuseumUseCaseImpl(get(), get())
    }
    viewModel {
        CollectionViewModel(get())
    }
}