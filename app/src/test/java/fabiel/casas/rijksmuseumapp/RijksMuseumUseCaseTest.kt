package fabiel.casas.rijksmuseumapp

import com.google.common.truth.Truth
import fabiel.casas.rijksmuseumapp.data.datasource.RijksCollectionPagingSource
import fabiel.casas.rijksmuseumapp.data.datasource.RijksMuseumDataSourceImpl
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCaseImpl
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * RijksMuseumApp
 * Created on 26/06/2023.
 * Author: johan
 */
class RijksMuseumUseCaseTest {
    private val api = RijksMuseumApiFake()
    private val rijksMuseumUseCase = RijksMuseumUseCaseImpl(
        dataSource = RijksMuseumDataSourceImpl(api),
        pagingSource = RijksCollectionPagingSource(rijksMuseumApi = api)
    )
    private val testScope = TestScope()

    @Test(expected = Exception::class)
    fun getCollectionDetails_givenAEmptyObjectNumber_throwException() {
        testScope.runTest {
            rijksMuseumUseCase.getCollectionDetails("")
        }
    }

    @Test
    fun getCollectionDetails_givenAValidObjectNumber_returnDetailState() {
        testScope.runTest {
            val result = rijksMuseumUseCase.getCollectionDetails("en-SK-A-128")
            Truth.assertThat(result).isEqualTo(AppConstants.detailsState)
        }
    }
}