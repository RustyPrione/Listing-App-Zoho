package Raja.Ragavan.ListingAppZoho

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import Raja.Ragavan.ListingAppZoho.R

class splashscreenActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler= Handler()
        handler.postDelayed({

            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // creating delay
    }
}
