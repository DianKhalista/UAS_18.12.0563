package com.omrobbie.pertandinganbola.mvp.detail

import com.omrobbie.pertandinganbola.model.TeamsItem

interface DetailView {

    fun showLoading()
    fun hideLoading()
    fun showTeamDetails(dataHomeTeam: List<TeamsItem>, dataAwayTeam: List<TeamsItem>)
}
