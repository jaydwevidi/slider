package com.example.page2

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(myToolbar)
        //<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        //past this in styles file

        setupImageSlider()
        setupNavViewDrawer()
    }

    fun addItemsToList(list : MutableList<SliderItem>){
        list.add(SliderItem("https://wallpapercave.com/wp/wp3850825.jpg", "", 3214))
        list.add(SliderItem("https://wallpapercave.com/wp/wp6058934.jpg", "", 3214))
        list.add(SliderItem("https://wallpapercave.com/wp/wp4676567.jpg", "", 3214))
        list.add(SliderItem("https://people.sc.fsu.edu/~jburkardt/data/jpg/auburn_logo.jpg", "", 3214))
    }

    fun setupNavViewDrawer(){

        toggle = ActionBarDrawerToggle(this , drawerLayout , R.string.app_name , R.string.g )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "asdf", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext , "452353" , Toast.LENGTH_LONG).show()
            }
            true
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setupImageSlider(){
        var list = mutableListOf<SliderItem>()
        addItemsToList(list)

        val x = SlideAdapter(list,applicationContext)
        imageSlider.setSliderAdapter(x)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else
        super.onBackPressed()
    }

}