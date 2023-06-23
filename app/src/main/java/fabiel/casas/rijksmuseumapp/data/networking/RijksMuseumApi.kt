package fabiel.casas.rijksmuseumapp.data.networking

import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
interface RijksMuseumApi {
    @GET("api/{culture}/collection")
    suspend fun getCollection(
        @Path("culture") culture: String,
        @Query("key") key: String,
        @Query("p") page: Int,
        @Query("ps") pageSize: Int,
    ): CollectionResponse

    @GET("api/{culture}/collection/{objectNumber}")
    suspend fun getCollectionObject(
        @Path("culture") culture: String,
        @Path("objectNumber") objectNumber: String,
        @Query("key") key: String,
    ): CollectionObjectResponse
}