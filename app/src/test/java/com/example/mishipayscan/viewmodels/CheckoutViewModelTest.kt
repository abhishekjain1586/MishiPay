package com.example.mishipayscan.viewmodels

import com.example.mishipayscan.domain.usecase.GetCartProductsUseCase
import com.example.mishipayscan.mockProducts
import com.example.mishipayscan.ui.viewmodels.CheckoutViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class CheckoutViewModelTest {

    @Mock
    lateinit var mockGetCartProductsUseCase: GetCartProductsUseCase

    private lateinit var viewModel: CheckoutViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testCartItems() = runTest {
        Mockito.`when`(mockGetCartProductsUseCase.invoke()).thenReturn(mockProducts.subList(0, 4))
        viewModel = CheckoutViewModel(
            getCartProductsUseCase = mockGetCartProductsUseCase
        )
        Assert.assertEquals(4, viewModel.uiState.value.products.size)
    }

    @Test
    fun testEmptyCartItems() = runTest {
        Mockito.`when`(mockGetCartProductsUseCase.invoke()).thenReturn(listOf())
        viewModel = CheckoutViewModel(
            getCartProductsUseCase = mockGetCartProductsUseCase
        )
        Assert.assertEquals(0, viewModel.uiState.value.products.size)
    }

    @Test
    fun testTotalAmount() = runTest {
        Mockito.`when`(mockGetCartProductsUseCase.invoke()).thenReturn(mockProducts.subList(0, 4))
        viewModel = CheckoutViewModel(
            getCartProductsUseCase = mockGetCartProductsUseCase
        )
        Assert.assertEquals(559.0, viewModel.uiState.value.total, 0.0)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}