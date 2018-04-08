package com.faisal.retrofit_kotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.faisal.retrofit_kotlin.R
import com.faisal.retrofit_kotlin.adapter.MoviesAdapter
import com.faisal.retrofit_kotlin.model.Movie
import com.faisal.retrofit_kotlin.model.MovieResponse
import com.faisal.retrofit_kotlin.remote.ApiClient
import com.faisal.retrofit_kotlin.remote.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val API_KEY = "6ed2279f7b98c9369069fe4760ac0e1f"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager= LinearLayoutManager(this)

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        var apiInterface : ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)

        val call : Call<MovieResponse> = apiInterface.getTopRatedMovie(API_KEY)
        call.enqueue(object : Callback<MovieResponse> {
           override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

               val statusCode : Int = response.code()
               val movieList : List<Movie> = response.body()!!.getResults()!!
               recyclerView.adapter = MoviesAdapter(movieList, R.layout.list_item_movie, applicationContext)
              /*  val movies = response.body()!!.getResults()
              Log.d("MainActivity", "Number of movies received: " + movies!!.size)*/
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // Log error here since request failed
                //Log.e(FragmentActivity.TAG, t.toString())
            }
        })

    }
}
