package fabiel.casas.rijksmuseumapp

import fabiel.casas.rijksmuseumapp.data.networking.RijksMuseumApi
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionResponse
import fabiel.casas.rijksmuseumapp.data.networking.response.CountFacets

/**
 * RijksMuseumApp
 * Created on 26/06/2023.
 * Author: johan
 */
class RijksMuseumApiFake: RijksMuseumApi {
    override suspend fun getCollection(
        culture: String,
        key: String,
        page: Int,
        pageSize: Int,
        sortBy: String
    ): CollectionResponse  = CollectionResponse(
        artObjects = emptyList(),
        count = 0,
        countFacets = CountFacets(
            hasimage = 0,
            ondisplay = 0
        ),
        elapsedMilliseconds = 0,
        facets = listOf(),
    )

    override suspend fun getCollectionObject(
        culture: String,
        objectNumber: String,
        key: String
    ): CollectionObjectResponse = AppConstants.collectionObjectResponse
}