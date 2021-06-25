package com.abdull.newsapp.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abdull.newsapp.di.DependencyContainer
import com.abdull.newsapp.getOrAwaitValueTest
import com.abdull.newsapp.repository.FakeNewsRepository
import com.abdull.newsapp.util.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class NewsViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    val dispatcher = TestCoroutineDispatcher()


    private lateinit var viewModel: NewsViewModel


    // dependencies

    private val dependencyContainer: DependencyContainer
    private val fakeNewsRepository: FakeNewsRepository

    init {
        dependencyContainer = DependencyContainer()
        dependencyContainer.build()
        fakeNewsRepository = dependencyContainer.newsRepository
    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val mockApplication = Mockito.mock(Application::class.java)
        val context = Mockito.mock(Context::class.java)
        val mockConnectivityManager = Mockito.mock(ConnectivityManager::class.java)
        Mockito.`when`(mockApplication.applicationContext).thenReturn(context)
        Mockito.`when`(mockApplication.getSystemService(Context.CONNECTIVITY_SERVICE))
            .thenReturn(mockConnectivityManager)
        viewModel = NewsViewModel(repository = fakeNewsRepository, application = mockApplication)

        Dispatchers.setMain(dispatcher)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        dispatcher.cleanupTestCoroutines()

    }





    @Test
    fun `local cache contains all elements from query`() = runBlocking {

        val query = "bitcoin"
        viewModel.getNews(query, isConnectedToInternet = true)
        val remote = fakeNewsRepository.network
        val local = fakeNewsRepository.local


        val remoteTitles = remote.map { it.title!! }
        val localTitles = local.map { it.title!! }

        assert(remoteTitles.containsAll(localTitles))

    }


    @Test
    fun `can search in offline mode`() = runBlocking {

        val query = "bitcoin"
        viewModel.getNews(query, isConnectedToInternet = true)
        viewModel.getNews(query, isConnectedToInternet = false)

        val localTitles = fakeNewsRepository.local.map { it.title!! }
        val remoteTitles = fakeNewsRepository.network.map { it.title!! }


        assert(remoteTitles.containsAll(localTitles))

    }


}