package gan0803.pj.sharedpreferencestudy

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = AppCompatActivity::class.java.simpleName
    }

    private val prefs by lazy {
        MySharedPreference(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs.savePreferences()
        prefs.readPreferences()

        val uri = Uri.parse("content://gan0803.pj.sharedpreferencestudy.provider/");
        val auth = "gan0803.pj.sharedpreferencestudy.provider"
        val cr = contentResolver
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Log.d(TAG, "use authority")
            cr.call(auth, "savePreferences", null, null)
            cr.call(auth, "readPreferences", null, null)
        } else {
            Log.d(TAG, "use URI")
            cr.call(uri, "savePreferences", null, null)
            cr.call(uri, "readPreferences", null, null)
        }
    }
}