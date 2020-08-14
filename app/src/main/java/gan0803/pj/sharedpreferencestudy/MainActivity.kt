package gan0803.pj.sharedpreferencestudy

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import gan0803.pj.sharedpreferencestudy.provider.MyPreferences

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

        val uri = Uri.parse(MyPreferences.URI);
        val cr = contentResolver
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Log.d(TAG, "use authority")
            cr.call(MyPreferences.AUTHORITY, MyPreferences.SAVE_PREFERENCE_METHOD, null, null)
            cr.call(MyPreferences.AUTHORITY, MyPreferences.READ_PREFERENCE_METHOD, null, null)
        } else {
            Log.d(TAG, "use URI")
            cr.call(uri, MyPreferences.SAVE_PREFERENCE_METHOD, null, null)
            cr.call(uri, MyPreferences.READ_PREFERENCE_METHOD, null, null)
        }
    }
}