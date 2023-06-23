package fabiel.casas.rijksmuseumapp.data.networking.response

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
data class CollectionResponse(
    val artObjects: List<ArtObject>,
    val count: Int,
    val countFacets: CountFacets,
    val elapsedMilliseconds: Int,
    val facets: List<Facet>
)

data class ArtObject(
    val hasImage: Boolean,
    val headerImage: HeaderImage,
    val id: String,
    val links: Links,
    val longTitle: String,
    val objectNumber: String,
    val permitDownload: Boolean,
    val principalOrFirstMaker: String,
    val productionPlaces: List<String>,
    val showImage: Boolean,
    val title: String,
    val webImage: WebImage
)

data class CountFacets(
    val hasimage: Int,
    val ondisplay: Int
)

data class Facet(
    val facets: List<FacetX>,
    val name: String,
    val otherTerms: Int,
    val prettyName: Int
)

data class HeaderImage(
    val guid: String,
    val height: Int,
    val offsetPercentageX: Int,
    val offsetPercentageY: Int,
    val url: String,
    val width: Int
)

data class Links(
    val self: String,
    val web: String
)

data class WebImage(
    val guid: String,
    val height: Int,
    val offsetPercentageX: Int,
    val offsetPercentageY: Int,
    val url: String,
    val width: Int
)

data class FacetX(
    val key: String,
    val value: Int
)