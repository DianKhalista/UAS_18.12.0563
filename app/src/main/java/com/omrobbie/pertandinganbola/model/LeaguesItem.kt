package com.omrobbie.pertandinganbola.model

data class LeaguesItem(val idLeague: String?, val strLeague: String?) {

    override fun toString(): String {
        return strLeague.toString()
    }
}
