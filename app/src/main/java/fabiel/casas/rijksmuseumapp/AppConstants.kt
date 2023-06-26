package fabiel.casas.rijksmuseumapp

import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import fabiel.casas.rijksmuseumapp.data.networking.response.Acquisition
import fabiel.casas.rijksmuseumapp.data.networking.response.AdlibOverrides
import fabiel.casas.rijksmuseumapp.data.networking.response.ArtObjectDetail
import fabiel.casas.rijksmuseumapp.data.networking.response.ArtObjectPage
import fabiel.casas.rijksmuseumapp.data.networking.response.Classification
import fabiel.casas.rijksmuseumapp.data.networking.response.CollectionObjectResponse
import fabiel.casas.rijksmuseumapp.data.networking.response.Dating
import fabiel.casas.rijksmuseumapp.data.networking.response.Links
import fabiel.casas.rijksmuseumapp.data.networking.response.PrincipalMaker
import fabiel.casas.rijksmuseumapp.data.networking.response.WebImage
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionItemState
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionState
import fabiel.casas.rijksmuseumapp.ui.screens.details.CollectionDetailState
import fabiel.casas.rijksmuseumapp.ui.screens.details.DetailsState
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
object AppConstants {
    const val COLLECTION_PAGE_SIZE = 100
    const val COLLECTION_SORT_BY = "artist"

    val collectionObjectResponse = CollectionObjectResponse(
        artObject = ArtObjectDetail(
            acquisition = Acquisition(
                creditLine = "",
                date = "detracto",
                method = "tamquam"
            ),
            artistRole = "",
            associations = listOf(),
            catRefRPK = listOf(),
            classification = Classification(
                events = listOf(),
                iconClassDescription = listOf(),
                iconClassIdentifier = listOf(),
                motifs = listOf(),
                objectNumbers = listOf(),
                people = listOf(),
                periods = listOf(),
                places = listOf()
            ),
            colors = listOf(),
            colorsWithNormalization = listOf(),
            copyrightHolder = String(),
            dating = Dating(
                period = 16,
                presentingDate = "1590",
                sortingDate = 7611,
                yearEarly = 2010,
                yearLate = 1996
            ),
            description = "De kindermoord te Bethlehem. Slachtpartij buiten de poorten van de stad. Naakte soldaten vermoorden de kinderen met messen en zwaarden.",
            dimensions = listOf(),
            documentation = listOf(),
            exhibitions = listOf(),
            hasImage = false,
            historicalPersons = listOf(),
            id = "en-SK-A-128",
            inscriptions = listOf(),
            label = null,
            labelText = "",
            language = "affert",
            links = Links(
                self = "curabitur",
                web = "reque"
            ),
            location = "viderer",
            longTitle = "The Massacre of the Innocents, Cornelis Cornelisz. van Haarlem, 1590",
            makers = listOf(),
            materials = listOf(),
            materialsThesaurus = listOf(),
            normalized32Colors = listOf(),
            normalizedColors = listOf(),
            objectCollection = listOf(),
            objectNumber = "en-SK-A-128",
            objectTypes = listOf(),
            physicalMedium = "venenatis",
            physicalProperties = listOf(),
            plaqueDescriptionDutch = null,
            plaqueDescriptionEnglish = null,
            principalMaker = "dissentiunt",
            principalMakers = listOf(PrincipalMaker(
                biography = "",
                dateOfBirth = "elaboraret",
                dateOfBirthPrecision = "",
                dateOfDeath = "adversarium",
                dateOfDeathPrecision = "",
                labelDesc = "Cornelis Cornelisz. van Haarlem (1562 - 11-nov-1638)",
                name = "Marvin Guerrero",
                nationality = "ponderum",
                occupation = listOf(),
                placeOfBirth = "novum",
                placeOfDeath = "voluptatibus",
                productionPlaces = listOf(),
                qualification = "",
                roles = listOf(),
                unFixedName = "Francis Valenzuela"

            )),
            principalOrFirstMaker = "omittantur",
            priref = "indoctum",
            productionPlaces = listOf(),
            productionPlacesThesaurus = listOf(),
            scLabelLine = "no",
            showImage = false,
            subTitle = "The Massacre of the Innocents, Cornelis Cornelisz. van Haarlem, 1590",
            techniques = listOf(),
            techniquesThesaurus = listOf(),
            title = "The Massacre of the Innocents",
            titles = listOf(),
            webImage = WebImage(
                guid = "elaboraret",
                height = 5866,
                offsetPercentageX = 3022,
                offsetPercentageY = 9488,
                url = "https://lh5.ggpht.com/JH0svNh0Pkov_W97MDHw8v2-qKS8AdixVJ-CiPL_xBECNdEyTBkicMvZBsqgW6GQ0TB9moKnfGUYacWQS32rqeoEjA4=s0",
                width = 6710

            )
        ),
        artObjectPage = ArtObjectPage(
            adlibOverrides = AdlibOverrides(
                etiketText = "",
                maker = "",
                titel = ""
            ),
            audioFile1 = "",
            audioFileLabel1 = "",
            audioFileLabel2 = "",
            createdOn = "quis",
            id = "tibique",
            lang = "dico",
            objectNumber = "epicurei",
            plaqueDescription = null,
            similarPages = listOf(),
            tags = listOf(),
            updatedOn = "blandit"
        ),
        elapsedMilliseconds = 1
    )

    val collectionItemState = CollectionItemState(
        objectNumber = "en-SK-A-128",
        collectionTitle = "The Massacre of the Innocents",
        description = "De kindermoord te Bethlehem. Slachtpartij buiten de poorten van de stad. Naakte soldaten vermoorden de kinderen met messen en zwaarden.",
        author = "Cornelis Cornelisz. van Haarlem",
        imageUrl = "https://lh5.ggpht.com/JH0svNh0Pkov_W97MDHw8v2-qKS8AdixVJ-CiPL_xBECNdEyTBkicMvZBsqgW6GQ0TB9moKnfGUYacWQS32rqeoEjA4=s0",
        webImageUrl = "https://lh3.googleusercontent.com/DT8hZMf-M0JTLYT3ofIuOcpYZwrnJOPYbCnz9To2oKEze6v__46G5r-LivsxiSqgf2PGc1YgqoEKNMYEgQ78rzV7HA=s0"
    )
    val detailsState = DetailsState(
        objectNumber = "en-SK-A-128",
        title = "The Massacre of the Innocents",
        imageUrl = "https://lh5.ggpht.com/JH0svNh0Pkov_W97MDHw8v2-qKS8AdixVJ-CiPL_xBECNdEyTBkicMvZBsqgW6GQ0TB9moKnfGUYacWQS32rqeoEjA4=s0",
        authors = listOf("Cornelis Cornelisz. van Haarlem (1562 - 11-nov-1638)"),
        subTitle = "The Massacre of the Innocents, Cornelis Cornelisz. van Haarlem, 1590",
        description = "De kindermoord te Bethlehem. Slachtpartij buiten de poorten van de stad. Naakte soldaten vermoorden de kinderen met messen en zwaarden.",
        presentingDate = "1590",
        period = "16"
    )

    val collectionStateSample = CollectionState(
        collection = MutableStateFlow(PagingData.from(listOf(collectionItemState)))
    )
    val collectionDetailState = CollectionDetailState(
        detailsState = mutableStateOf(detailsState)
    )
}