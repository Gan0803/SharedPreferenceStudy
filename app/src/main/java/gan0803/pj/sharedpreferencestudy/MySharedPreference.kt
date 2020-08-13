package gan0803.pj.sharedpreferencestudy

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class MySharedPreference {

    companion object {
        private val TAG = MySharedPreference::class.java.simpleName
    }

    private lateinit var prefs: SharedPreferences

    fun savePreferences(activity: Activity) {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(
                activity.resources.getString(gan0803.pj.sharedpreferencestudy.R.string.saved_string_key),
                "test string"
            )
            putBoolean(
                activity.resources.getString(gan0803.pj.sharedpreferencestudy.R.string.saved_boolean_key),
                true
            )
            putInt(
                activity.resources.getString(gan0803.pj.sharedpreferencestudy.R.string.saved_int_key),
                12345
            )
            commit()
        }
    }

    fun readPreferences(activity: Activity) {

        prefs = activity.getPreferences(Context.MODE_PRIVATE)

        val stringPreference = prefs.getString(
            activity.resources.getString(R.string.saved_string_key),
            "default value"
        )

        val booleanPreference = prefs.getBoolean(
            activity.resources.getString(R.string.saved_boolean_key),
            false
        )

        val intPreference = prefs.getInt(
            activity.resources.getString(R.string.saved_int_key),
            0
        )

        Log.d(TAG, "string: {$stringPreference}")
        Log.d(TAG, "boolean: {$booleanPreference}")
        Log.d(TAG, "int: {$intPreference}")
    }
}