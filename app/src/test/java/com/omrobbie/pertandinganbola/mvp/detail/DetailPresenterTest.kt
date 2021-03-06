package com.omrobbie.pertandinganbola.mvp.detail

import com.google.gson.Gson
import com.omrobbie.pertandinganbola.model.TeamDetailResponse
import com.omrobbie.pertandinganbola.model.TeamsItem
import com.omrobbie.pertandinganbola.network.ApiRepository
import com.omrobbie.pertandinganbola.network.TheSportsDbApi
import com.omrobbie.pertandinganbola.utils.TestContextProvider
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DetailPresenterTest {

    @Mock
    lateinit var view: DetailView

    @Mock
    lateinit var apiRepository: ApiRepository

    @Mock
    lateinit var gson: Gson

    lateinit var presenter: DetailPresenter

    @Before
    fun setupEnv() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun getTeamDetails() {
        val data: MutableList<TeamsItem> = mutableListOf()
        val response = TeamDetailResponse(data)
        val id = "1234"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportsDbApi.getTeamDetails(id)),
                TeamDetailResponse::class.java)
        ).thenReturn(response)

        presenter.getTeamDetails(id, id)

        verify(view).showLoading()
        verify(view).showTeamDetails(response.teams!!, response.teams!!)
        verify(view).hideLoading()
    }
}
