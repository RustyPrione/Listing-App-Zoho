package Raja.Ragavan.ListingAppZoho.adaptor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Raja.Ragavan.ListingAppZoho.Country
import Raja.Ragavan.ListingAppZoho.Main2Activity
import Raja.Ragavan.ListingAppZoho.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.country_name_layout.view.*

class CountryNameAdapter(val context: Context, var CountryList: List<Country>) :
    RecyclerView.Adapter<CountryNameAdapter.CustomViewHolder>() {
    // Initialize Recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(
            R.layout.country_name_layout,
            parent, false
        )
        return CustomViewHolder(
            layoutInflater
        )
    }
    // get country list size
    override fun getItemCount(): Int {
        return CountryList.size
    }

    //handle the text and append the text to the end of the TextView
    @SuppressLint("SetTextI18n")
    // Display the current text and location in view holder custom view
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //get country name
        var name = CountryList[position].name
        // show country name in CustomViewHolder
        holder.view.name?.text = CountryList[position].name
        // show country capital in CustomViewHolder
        holder.view.capital?.text = "Capital - " +CountryList[position].capital

        // Using Glide to show SVG images
        var thumbnailImageView = holder.view.flag_imageView
        GlideToVectorYou.justLoadImage(holder.view.context as Activity?, Uri.parse(CountryList[position].flag), thumbnailImageView)

        //Passing name parameter in CustomViewHolder to be sent to next activity
        holder?.name = name
    }

    class CustomViewHolder(var view: View,var name: String? = null): RecyclerView.ViewHolder(view){
        companion object {
            var country_name = "name"
        }
        init{
            view.setOnClickListener{
                var intent = Intent(view.context, Main2Activity::class.java)
                // Transfer country name to another activity
                intent.putExtra(country_name, name)
                view.context.startActivity(intent)
            }
        }
    }

}