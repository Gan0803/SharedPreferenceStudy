package gan0803.pj.sharedpreferencestudy

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }


    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savePreferences()
        readPreferences()
    }

    private fun savePreferences() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(getString(R.string.saved_string_key), "test string")
            putBoolean(getString(R.string.saved_boolean_key), true)
            putInt(getString(R.string.saved_int_key), 12345)
            commit()
        }
    }

    private fun readPreferences() {

        prefs = getPreferences(Context.MODE_PRIVATE)

        val stringPreference = prefs.getString(
            getString(R.string.saved_string_key),
            "default value"
        )

        val booleanPreference = prefs.getBoolean(
            getString(R.string.saved_boolean_key),
            false
        )

        val intPreference = prefs.getInt(
            getString(R.string.saved_int_key),
            0
        )

        Log.d(TAG, "string: {$stringPreference}")
        Log.d(TAG, "boolean: {$booleanPreference}")
        Log.d(TAG, "int: {$intPreference}")
    }
}