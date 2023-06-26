package fabiel.casas.rijksmuseumapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionScreen
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionViewModel
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

/**
 * RijksMuseumApp
 * Created on 26/06/2023.
 * Author: johan
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class CollectionScreenTest: KoinTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        stopKoin()
        startKoin {
            modules(module {
                viewModel {
                    CollectionViewModel(RijksMuseumUseCaseFake())
                }
            })
        }
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun loadCollections_assertTitleDisplay() {
        composeTestRule.setContent {
            RijksMuseumAppTheme {
                CollectionScreen(onNavDetailCollectionAction = {})
            }
        }
        composeTestRule.onNodeWithText(text = "Waiting for items to load from the backend").assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "RijksMuseum").assertIsDisplayed()
    }
}