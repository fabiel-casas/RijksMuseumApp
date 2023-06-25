package fabiel.casas.rijksmuseumapp.data.datasource

import fabiel.casas.rijksmuseumapp.BuildConfig
import fabiel.casas.rijksmuseumapp.data.networking.RijksMuseumApi
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse
import fabiel.casas.rijksmuseumapp.getCulture

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
class RijksMuseumDataSourceImpl(
    private val rijksMuseumApi: RijksMuseumApi
): RijksMuseumDataSource {
    override suspend fun findCollectionObject(objectNumber: String): CollectionObjectResponse {
        return rijksMuseumApi.getCollectionObject(
            culture = getCulture(),
            objectNumber = objectNumber,
            key = BuildConfig.MUSEUM_API_KEY
        )
    }

}