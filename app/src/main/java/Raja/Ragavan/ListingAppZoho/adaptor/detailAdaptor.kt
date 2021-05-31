package Raja.Ragavan.ListingAppZoho.adaptor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import Raja.Ragavan.ListingAppZoho.Country
import Raja.Ragavan.ListingAppZoho.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.detail_layout.view.*

class DetailViewAdaptor(var context: Context, var CountryList: List<Country>) :
    RecyclerView.Adapter<DetailViewAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        println("got it")
        Log.e(TAG,"got it")
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.detail_layout,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return CountryList.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Getting All Data And passing to ViewHolder

        holder?.capital?.text = "Capital - "+ CountryList[position].capital
        holder?.alpha2Code?.text = "Alpha2Code   - "+CountryList[position].alpha2Code
        holder?.alpha3Code?.text = "Alpha3Code   - "+CountryList[position].alpha3Code
        holder?.region?.text ="Region       - "+ CountryList[position].region
        holder?.area?.text = "Area         - "+CountryList[position].area.toString()
        holder?.cioc?.text ="Cioc         - "+ CountryList[position].cioc
        holder?.gini?.text ="Gini         - "+ CountryList[position].gini.toString()
        holder?.nativeName?.text ="Native Name  - "+ CountryList[position].nativeName
        holder?.numericCode?.text ="Numeric Code - "+ CountryList[position].numericCode
        holder?.population?.text = "Population   - "+CountryList[position].population.toString()
        holder?.subregion?.text ="SubRegion    - "+ CountryList[position].subregion
        holder?.demonym?.text ="Demonym      - "+ CountryList[position].demonym

        val borders_list = CountryList[position].borders
        if(borders_list.isEmpty()){
            var borders:String = "  Boders Not Available "
            holder?.borders?.text = borders.trim()
        }else{
            var borders:String = ""
            borders+="\n"
            var count_border = 1
            for(item in borders_list){
                borders=  borders + count_border + "."+ item
                borders+="\n"
                count_border++
            }
            holder?.borders?.text = borders.trim()
        }


        val callingCodes_list = CountryList[position].callingCodes
        if(callingCodes_list.isEmpty()){
            var callingCodes:String = " Calling Codes Not Available"
            holder?.callingCodes?.text = callingCodes.trim()
        }else{
            var callingCodes:String = ""
            callingCodes+="\n"
            var count_calling = 1
            for(item in callingCodes_list){
                callingCodes= callingCodes +count_calling +"."+ "`"+item+"`"
                callingCodes+="\n"
            }
            holder?.callingCodes?.text = callingCodes.trim()
        }

        val latlng_list = CountryList[position].latlng
        if(latlng_list.isEmpty()){
            var latlng:String = " Latitude and Longitude Not Available"
            holder?.latlng?.text = latlng
        }else{
            var latlng:String = " "
            for(item in latlng_list){
                latlng+= item.toString() + ","
            }
            holder?.latlng?.text = latlng.dropLast(1)
        }

        val timezones_list = CountryList[position].timezones
        if(timezones_list.isEmpty()){
            var timezones:String = "  Timezone Not Available"
            holder?.timezones?.text = timezones.trim()
        }else{
            var timezones:String = "  "
            timezones+="\n"
            var count_timezon = 1
            for(item in timezones_list){
                timezones = timezones + count_timezon + "." + item
                timezones+="\n"
                count_timezon++
            }
            holder?.timezones?.text = timezones.trim()
        }

        val topLevelDomain_list = CountryList[position].topLevelDomain
        if(topLevelDomain_list.isEmpty()){
            var topLevelDomain:String = "   Domain Not Available"
            holder?.topLevelDomain?.text = topLevelDomain.trim()
        }else{
            var topLevelDomain:String = ""
            topLevelDomain+="\n"
            var count_toplevedomain  = 1
            for(item in topLevelDomain_list){
                topLevelDomain = topLevelDomain + count_toplevedomain +  "."+ '"'+item+'"'
                topLevelDomain+="\n"
                count_toplevedomain++
            }
            holder?.topLevelDomain?.text = topLevelDomain.trim()
        }

        val altSpellings_list = CountryList[position].altSpellings
        if(altSpellings_list.isEmpty()){
            var altSpellings:String = "  Alt Spellings Not Available"
            holder?.altSpellings?.text = altSpellings.trim()
        }else{
            var altSpellings:String = " "
            altSpellings+="\n"
            var count_altspellings = 1
            for(item in altSpellings_list){
                altSpellings= altSpellings + count_altspellings+ "."+item
                altSpellings+="\n"
                count_altspellings++
            }
            holder?.altSpellings?.text = altSpellings.trim()
        }


        val language_list = CountryList[position].languages
        var name:String = ""
        var count_language = 1
        for(item in language_list){
            name= name + count_language +"."+"Name        - "+item.name
            name+="\n"
            name= name + "  Native Name - "+item.nativeName
            name+="\n"
            name = name +"  iso6391     - "+ item.iso6391
            name+="\n"
            name= name +"  iso6392     - "+item.iso6392
            name+="\n"
            name+="\n"
            count_language++
        }
        holder?.lang_name?.text = name.trim()


        val Translations_list = CountryList[position].translations
        var Translations:String = "  "
            Translations= Translations+ ".IT - "+ Translations_list.it
            Translations+="\n"
            Translations= Translations+ ".BR - "+Translations_list.br
            Translations+="\n"
            Translations= Translations+ ".DE - "+Translations_list.de
            Translations+="\n"
            Translations= Translations+ ".ES - "+Translations_list.es
            Translations+="\n"
            Translations= Translations+ ".FA - "+Translations_list.fa
            Translations+="\n"
            Translations= Translations+ ".FR - "+Translations_list.fr
            Translations+="\n"
            Translations= Translations+ ".HR - "+Translations_list.hr
            Translations+="\n"
            Translations= Translations+ ".JA - "+Translations_list.ja
            Translations+="\n"
            Translations= Translations+ ".NL - "+Translations_list.nl
            Translations+="\n"
            Translations= Translations+ ".PT - "+Translations_list.pt
            Translations+="\n"
        holder?.Translations?.text = Translations.trim()

        val Currency_list = CountryList[position].currencies
        var Currency:String = " "
            Currency+= "\n"
        var count_currency = 1
        for(item in Currency_list){
            Currency= Currency+ count_currency + ".Name   - "+item.name
            Currency+="\n"
            Currency= Currency + "  Code   - "+item.code
            Currency+="\n"
            Currency= Currency + "  Symbol - "+item.symbol
            Currency+="\n"
            count_currency++
        }
        holder?.Currency?.text = Currency.trim()


        val RegionalBloc_list = CountryList[position].regionalBlocs
        if(RegionalBloc_list.isEmpty()){
            var RegionalBloc:String = " Regional Bloc Not Available"
            holder?.regionalBloc?.text = RegionalBloc.trim()
        }else{
            var RegionalBloc:String = " "
            RegionalBloc+="\n"
            var count_RegionalBloc = 1
            for(item in RegionalBloc_list){
                RegionalBloc =RegionalBloc + count_RegionalBloc+ "."+ "Name         - "+item.name
                RegionalBloc+="\n"
                RegionalBloc= RegionalBloc + "  Acronym      - "+ item.acronym
                RegionalBloc+="\n"
                val otherAcronyms_list = item.otherAcronyms
                if(otherAcronyms_list.isEmpty()){
                    var otherAcronyms:String = ""
                    RegionalBloc = RegionalBloc +"  \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC00\uD835\uDC1C\uD835\uDC2B\uD835\uDC28\uD835\uDC27\uD835\uDC32\uD835\uDC26 -\n     Other Acronyms Not Available " + otherAcronyms
                    RegionalBloc+="\n"
                }else{
                    var otherAcronyms:String = ""
                    var count_otherAcronyms = 1
                    for(newItem in otherAcronyms_list){
                        otherAcronyms= otherAcronyms+"     "+ count_otherAcronyms +". "+newItem
                        otherAcronyms+="\n"
                        count_otherAcronyms++
                    }
                    RegionalBloc = RegionalBloc +"  \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC00\uD835\uDC1C\uD835\uDC2B\uD835\uDC28\uD835\uDC27\uD835\uDC32\uD835\uDC26      -" + otherAcronyms
                    RegionalBloc+="\n"
                }
                val otherNames_list = item.otherNames
                if(otherNames_list.isEmpty()){
                    var otherNames:String = ""
                    RegionalBloc= RegionalBloc +"  \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC0D\uD835\uDC1A\uD835\uDC26\uD835\uDC1E -\n     Other Names Not Available "+otherNames
                    RegionalBloc+="\n"
                }else{
                    var otherNames:String = ""
                    var count_othername = 1
                    for(newItems in otherNames_list){
                        otherNames= otherNames+"     "  + count_othername + ". "+newItems
                        otherNames+="\n"
                        count_othername++
                    }
                    RegionalBloc= RegionalBloc +"  \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC0D\uD835\uDC1A\uD835\uDC26\uD835\uDC1E   -\n"+otherNames
                    RegionalBloc+="\n"
                }
                count_RegionalBloc++
            }
            holder?.regionalBloc?.text = RegionalBloc.trim()
        }
        // Uses Glide to load SVG image in detail activity
        var thumbnailImageView = holder?.image
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(CountryList[position].flag), thumbnailImageView)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //Connecting Data to respective TextView
        var capital: TextView = view.country_capital
        var alpha2Code: TextView = view.country_alpha2Code
        var alpha3Code: TextView = view.country_alpha3Code
        var region: TextView = view.country_region
        var image: ImageView = view.flagimageView
        var lang_name: TextView = view.lang_name
        var regionalBloc: TextView = view.country_regionalBloc
        var area: TextView = view.country_area
        var cioc: TextView = view.country_cioc
        var demonym: TextView = view.country_demonym
        var gini: TextView = view.country_gini
        var nativeName: TextView = view.country_nativeName
        var numericCode: TextView = view.country_numericCode
        var population: TextView = view.country_population
        var subregion: TextView = view.country_subregion
        var altSpellings: TextView = view.country_altSpellings
        var borders: TextView = view.country_borders
        var callingCodes: TextView = view.country_callingCodes
        var latlng: TextView = view.country_latlng
        var timezones: TextView = view.country_timezones
        var topLevelDomain: TextView = view.country_topLevelDomain
        var Currency: TextView = view.country_Currency
        var Translations: TextView = view.country_Translations
    }
}



