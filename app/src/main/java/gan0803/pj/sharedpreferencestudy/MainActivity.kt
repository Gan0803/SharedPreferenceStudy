package gan0803.pj.sharedpreferencestudy

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    private val prefs by lazy {
//        MySharedPreference(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        prefs.savePreferences()
//        prefs.readPreferences()

        val uri = Uri.parse("content://gan0803.pj.sharedpreferencestudy.provider/");
        val cr = contentResolver
        cr.call(uri, "savePreferences", null, null)
        cr.call(uri, "readPreferences", null, null)
    }
}