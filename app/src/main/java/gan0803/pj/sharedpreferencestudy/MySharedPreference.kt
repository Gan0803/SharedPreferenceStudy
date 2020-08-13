package gan0803.pj.sharedpreferencestudy

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class MySharedPreference {

    companion object {
        private val TAG = MySharedPreference::class.java.simpleName
        const val SAVED_STRING_KEY = "SavedStringKey"
        const val SAVED_BOOLEAN_KEY = "SavedBooleanKey"
        const val SAVED_INT_KEY = "SavedIntKey"
    }

    private var prefs: SharedPreferences

    constructor(activity: Activity) {
        prefs = activity.getSharedPreferences("savedPreferences", Context.MODE_PRIVATE)
    }

    fun savePreferences() {
        with(prefs.edit()) {
            putString(
                SAVED_STRING_KEY,
                "test string"
            )
            putBoolean(
                SAVED_BOOLEAN_KEY,
                true
            )
            putInt(
                SAVED_INT_KEY,
                12345
            )
            commit()
        }
    }

    fun readPreferences() {

        val stringPreference = prefs.getString(
            SAVED_STRING_KEY,
            "default value"
        )

        val booleanPreference = prefs.getBoolean(
            SAVED_BOOLEAN_KEY,
            false
        )

        val intPreference = prefs.getInt(
            SAVED_INT_KEY,
            0
        )

        Log.d(TAG, "string: {$stringPreference}")
        Log.d(TAG, "boolean: {$booleanPreference}")
        Log.d(TAG, "int: {$intPreference}")
    }
}