package com.poohxx.kotlinfishermanhandbook

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    var adapter : MyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLa:DrawerLayout?=null
        drawerLa = findViewById(R.id.drawerLayout)
        drawerLa?.closeDrawer(GravityCompat.START)


        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)


        val rcView = findViewById<RecyclerView>(R.id.rcView)


        var list = ArrayList<ListItem>()
        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
        resources.getStringArray(R.array.fish_content),
        getImageId(R.array.fish_pic_array)))


        adapter = MyAdapter(list, this)
        rcView.hasFixedSize()
        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(this)

            }

    override fun onNavigationItemSelected(item: MenuItem): Boolean
    {


        when(item.itemId)
        {

            R.id.vehicle ->
            {
                Toast.makeText(this, "Vehicle", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_pic_array)))
            }
            R.id.parts ->
            {
                Toast.makeText(this,"Parts", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.parts),
                    resources.getStringArray(R.array.parts_content),
                    getImageId(R.array.parts_pic_array)))
            }
            R.id.status ->
            {
                Toast.makeText(this,"Status", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.status),
                    resources.getStringArray(R.array.status_content),
                    getImageId(R.array.status_pic_array)))
            }
            R.id.history ->
            {
                Toast.makeText(this,"History", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.history),
                    resources.getStringArray(R.array.history_content),
                    getImageId(R.array.history_pic_array)))
            }

        }

        var drawerLa:DrawerLayout? = null
        drawerLa = findViewById(R.id.drawerLayout)
        drawerLa?.closeDrawer(GravityCompat.START)


        return true
    }
    fun fillArrays(titleArray: Array<String>,contentArray: Array<String>, imageArray:IntArray): List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size -1)
        {
            var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int) : IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }


}