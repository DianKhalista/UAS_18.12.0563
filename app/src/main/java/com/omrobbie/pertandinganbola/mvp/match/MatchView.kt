package com.omrobbie.pertandinganbola.mvp.match

import com.omrobbie.pertandinganbola.model.EventsItem
import com.omrobbie.pertandinganbola.model.LeagueResponse

interface MatchView {

    fun showLoading()
    fun hideLoading()
    fun showEmptyData()
    fun showLeagueList(data: LeagueResponse)
    fun showEventList(data: List<EventsItem>)
}
