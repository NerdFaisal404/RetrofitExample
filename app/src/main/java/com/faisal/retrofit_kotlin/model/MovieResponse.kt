package com.faisal.retrofit_kotlin.model

import com.google.gson.annotations.SerializedName



class MovieResponse {
    @SerializedName("page")
    private var page: Int = 0
    @SerializedName("results")
    private var results: List<Movie>? = null
    @SerializedName("total_results")
    private var totalResults: Int = 0
    @SerializedName("total_pages")
    private var totalPages: Int = 0

    fun getPage(): Int {
        return page
    }

    fun setPage(page: Int) {
        this.page = page
    }

    fun getResults(): List<Movie>? {
        return results
    }

    fun setResults(results: List<Movie>) {
        this.results = results
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun setTotalResults(totalResults: Int) {
        this.totalResults = totalResults
    }

    fun getTotalPages(): Int {
        return totalPages
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }
}