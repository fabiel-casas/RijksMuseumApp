package fabiel.casas.rijksmuseumapp.data.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
object RetrofitConfiguration {

    fun build(): Retrofit = Retrofit.Builder()
        .baseUrl("http://www.rijksmuseum.nl/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
}