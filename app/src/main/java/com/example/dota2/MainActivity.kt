package com.example.dota2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dota2.databinding.ActivityMainBinding
import com.example.dota2.ui.Settings.SettingsActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.activityMain)
        setSupportActionBar(binding.appBarMain.toolbar)


        binding.appBarMain.fab.setOnClickListener { view ->
            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.opendota.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

            val dota2Presentation: Dota2Presentation = retrofit.create(Dota2Presentation::class.java)

            dota2Presentation.getCharacterById().enqueue(object: Callback<DataModel>{
                override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                    Log.i("MainActivity", response.toString())
                    var gson  = Gson()
                    Snackbar.make(view, "${response.body()}", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

                }

                override fun onFailure(call: Call<DataModel>, t: Throwable) {
                    Log.i("MainActivity", t.message ?: "Null Message")
                }
            })


        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.aboutFragment2 , R.id.loginFragment
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        val settingsIntent = Intent(this,
            SettingsActivity::class.java);
        when (id) {
            R.id.action_settings -> startActivity(settingsIntent)

        }
        return super.onOptionsItemSelected(item) 
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}


