package Raja.Ragavan.ListingAppZoho

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.widget.EditText
import Raja.Ragavan.ListingAppZoho.adaptor.CountryNameAdapter
import Raja.Ragavan.ListingAppZoho.R
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var countries: MutableList<Country> = ArrayList() // get and store countries names in array list
    var displayList: MutableList<Country> = ArrayList() //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Setting up retrofit for url responce
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://restcountries.eu/rest/v2/").build()
        // Create a data class to fetch and hold the data from api
        val countryApi = retrofit.create(INetworkAPI::class.java)
        // get all country name and hold as list
        var response: Observable<List<Country>> = countryApi.getAllPosts()
        // do task in background and getting result in main thread
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            layoutManager = LinearLayoutManager(this)
            rv__list_name.layoutManager = layoutManager
            // calling country adaptor to show country flag , country name and country capital
            rv__list_name.adapter =
                CountryNameAdapter(this, it)

            fun addData() {
                for(item in it ){
                    // Adding data to countries array list for filtering
                    countries.add(item)
                }
            }
            addData()
        }
    }


    // Initiating Search option on toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
//            searchView.layoutParams = ActionBar.LayoutParams(Gravity.RIGHT)
            val editext = searchView.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            editext.hint = "Search here..."
            // Getting the query from search bar
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }
                // converting query to text and searching the text
                override fun onQueryTextChange(newText: String?): Boolean {
                    // delete previous search data
                    displayList.clear()
                    if (newText!!.isNotEmpty()) {
                        val search = newText.toLowerCase()
                        // search matching text in countries array list
                        countries.forEach {

                            if (it.name.toLowerCase().contains(search)) {
                                Log.d("TAG",it.name)
                                //  add that matching countries to display list to display matching countires for search keyword
                                displayList.add(it)
                            }
                        }
                    } else {
                        displayList.addAll(countries)
                    }

                    rv__list_name.adapter =
                        CountryNameAdapter(
                            baseContext,
                            displayList
                        )
                    //  notify changes are in done
                    rv__list_name.adapter?.notifyDataSetChanged()
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }


}
