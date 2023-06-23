package fabiel.casas.rijksmuseumapp.data.datasource

import fabiel.casas.rijksmuseumapp.data.networking.RijksMuseumApi
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
class RijksMuseumDataSourceImpl(
    private val rijksMuseumApi: RijksMuseumApi
): RijksMuseumDataSource {
    override suspend fun findCollectionObject(objectNumber: String): CollectionObjectResponse {
        TODO("Not yet implemented")
    }

}