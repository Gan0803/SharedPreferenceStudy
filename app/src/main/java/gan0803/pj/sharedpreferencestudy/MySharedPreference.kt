package gan0803.pj.sharedpreferencestudy

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class MySharedPreference {

    companion object {
        private val TAG = MySharedPreference::class.java.simpleName
        const val SAVED_STRING_LOCAL_KEY = "SavedStringLocalKey"
        const val SAVED_BOOLEAN_LOCAL_KEY = "SavedBooleanLocalKey"
        const val SAVED_INT_LOCAL_KEY = "SavedIntLocalKey"
    }

    private var prefs: SharedPreferences

    constructor(activity: Activity) {
        prefs = activity.getSharedPreferences("savedPreferences", Context.MODE_PRIVATE)
    }

    fun savePreferences() {
        with(prefs.edit()) {
            putString(
                SAVED_STRING_LOCAL_KEY,
                "test local string"
            )
            putBoolean(
                SAVED_BOOLEAN_LOCAL_KEY,
                false
            )
            putInt(
                SAVED_INT_LOCAL_KEY,
                987654321
            )
            commit()
        }
    }

    fun readPreferences() {

        val stringPreference = prefs.getString(
            SAVED_STRING_LOCAL_KEY,
            "default value"
        )

        val booleanPreference = prefs.getBoolean(
            SAVED_BOOLEAN_LOCAL_KEY,
            false
        )

        val intPreference = prefs.getInt(
            SAVED_INT_LOCAL_KEY,
            0
        )

        Log.d(TAG, "local string: {$stringPreference}")
        Log.d(TAG, "local boolean: {$booleanPreference}")
        Log.d(TAG, "local int: {$intPreference}")
    }
}