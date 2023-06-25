package fabiel.casas.rijksmuseumapp.data.networking.response

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
data class CollectionObjectResponse(
    val artObject: ArtObjectDetail,
    val artObjectPage: ArtObjectPage,
    val elapsedMilliseconds: Int
)

data class ArtObjectDetail(
    val acquisition: Acquisition,
    val artistRole: Any,
    val associations: List<Any>,
    val catRefRPK: List<Any>,
    val classification: Classification,
    val colors: List<Color>,
    val colorsWithNormalization: List<ColorsWithNormalization>,
    val copyrightHolder: Any,
    val dating: Dating,
    val description: String?,
    val dimensions: List<Dimension>,
    val documentation: List<Any>,
    val exhibitions: List<Any>,
    val hasImage: Boolean,
    val historicalPersons: List<Any>,
    val id: String,
    val inscriptions: List<Any>,
    val label: Label?,
    val labelText: Any,
    val language: String,
    val links: Links,
    val location: String,
    val longTitle: String,
    val makers: List<Any>,
    val materials: List<String>,
    val materialsThesaurus: List<Any>,
    val normalized32Colors: List<Normalized32Color>,
    val normalizedColors: List<Normalized32Color>,
    val objectCollection: List<String>,
    val objectNumber: String,
    val objectTypes: List<String>,
    val physicalMedium: String,
    val physicalProperties: List<Any>,
    val plaqueDescriptionDutch: String?,
    val plaqueDescriptionEnglish: String?,
    val principalMaker: String,
    val principalMakers: List<PrincipalMaker>,
    val principalOrFirstMaker: String,
    val priref: String,
    val productionPlaces: List<Any>,
    val productionPlacesThesaurus: List<Any>,
    val scLabelLine: String,
    val showImage: Boolean,
    val subTitle: String,
    val techniques: List<Any>,
    val techniquesThesaurus: List<Any>,
    val title: String,
    val titles: List<String>,
    val webImage: WebImage?
)

data class ArtObjectPage(
    val adlibOverrides: AdlibOverrides,
    val audioFile1: Any,
    val audioFileLabel1: Any,
    val audioFileLabel2: Any,
    val createdOn: String,
    val id: String,
    val lang: String,
    val objectNumber: String,
    val plaqueDescription: String?,
    val similarPages: List<Any>,
    val tags: List<Any>,
    val updatedOn: String
)

data class Acquisition(
    val creditLine: Any,
    val date: String,
    val method: String
)

data class Classification(
    val events: List<Any>,
    val iconClassDescription: List<String>,
    val iconClassIdentifier: List<String>,
    val motifs: List<Any>,
    val objectNumbers: List<String>,
    val people: List<Any>,
    val periods: List<Any>,
    val places: List<Any>
)

data class Color(
    val hex: String,
    val percentage: Int
)

data class ColorsWithNormalization(
    val normalizedHex: String,
    val originalHex: String
)

data class Dating(
    val period: Int,
    val presentingDate: String,
    val sortingDate: Int,
    val yearEarly: Int,
    val yearLate: Int
)

data class Dimension(
    val part: String,
    val precision: Any,
    val type: String,
    val unit: String,
    val value: String
)

data class Label(
    val date: String,
    val description: String?,
    val makerLine: String,
    val notes: String,
    val title: String?,
)

data class Normalized32Color(
    val hex: String,
    val percentage: Int
)

data class PrincipalMaker(
    val biography: Any,
    val dateOfBirth: String,
    val dateOfBirthPrecision: Any,
    val dateOfDeath: String,
    val dateOfDeathPrecision: Any,
    val labelDesc: String,
    val name: String,
    val nationality: String,
    val occupation: List<String>,
    val placeOfBirth: String,
    val placeOfDeath: String,
    val productionPlaces: List<Any>,
    val qualification: Any,
    val roles: List<String>,
    val unFixedName: String
)

data class AdlibOverrides(
    val etiketText: Any,
    val maker: Any,
    val titel: Any
)