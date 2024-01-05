package com.example.sesion10_11

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.sesion10_11.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service: AlbumApiService
    lateinit var recyclerAlbum: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        recyclerAlbum = findViewById(R.id.rcvAlbum)
        recyclerAlbum.layoutManager = LinearLayoutManager(this)
        service = retrofit.create<AlbumApiService>(AlbumApiService::class.java)

        obtenerAlbum()

    }

    fun obtenerAlbum(){

        service.getAllPosts().enqueue(object: Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums: List<Album>? = response?.body()
                recyclerAlbum.adapter = AlbumAdapter(albums!!)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
               t?.printStackTrace()
            }


        })
    }


}