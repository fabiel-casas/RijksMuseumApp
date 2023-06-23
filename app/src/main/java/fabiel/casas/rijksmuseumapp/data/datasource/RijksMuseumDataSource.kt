package fabiel.casas.rijksmuseumapp.data.datasource

import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
interface RijksMuseumDataSource {
    suspend fun findCollectionObject(objectNumber: String): CollectionObjectResponse
}