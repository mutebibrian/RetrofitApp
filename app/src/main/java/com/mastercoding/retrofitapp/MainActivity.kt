package com.mastercoding.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.mastercoding.retrofitapp.databinding.ActivityMainBinding
import retrofit2.Response
import java.sql.Ref

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview : TextView = findViewById(R.id.textView)

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)


        val reponseLiveData : LiveData<Response<Albums>> =
            liveData {
              //  val response = retrofitService.getAlbums()

                val response2 = retrofitService.getSpecificAlbums(6)
                emit(response2)
            }

        reponseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()

            if (albumsList !=null){
                while (albumsList.hasNext()){
                    val albumItem = albumsList.next()
                  //  Log.i("TAGY",albumItem.title)

                    val result = " Album Title: ${albumItem.title} \n"

                    textview.append(result)


                }
            }
        })
    }

}