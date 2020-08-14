package gan0803.pj.sharedpreferencestudy.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log

class MyContentProvider : ContentProvider() {

    companion object {
        private val TAG = ContentProvider::class.java.simpleName
        const val SAVED_PREFERENCES = "savedPreferences"
    }

    private lateinit var prefs: SharedPreferences

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to delete one or more rows")
    }

    override fun getType(uri: Uri): String? {
        TODO(
            "Implement this to handle requests for the MIME type of the data" +
                    "at the given URI"
        )
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    override fun onCreate(): Boolean {
        prefs = context!!.getSharedPreferences(SAVED_PREFERENCES, Context.MODE_PRIVATE)
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        TODO("Implement this to handle query requests from clients.")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        TODO("Implement this to handle requests to update one or more rows.")
    }

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
        Log.d(TAG, "call: {$method}")
        when (method) {
            MyPreferences.GET_STRING_PREFERENCE_METHOD -> {
                Log.d(TAG, "get")
                getStringPreference()
            }
            MyPreferences.PUT_STRING_PREFERENCE_METHOD -> {
                Log.d(TAG, "put")
                putStringPreference(arg ?: "")
            }
            MyPreferences.SAVE_PREFERENCE_METHOD -> {
                Log.d(TAG, "save")
                savePreferences()
            }
            MyPreferences.READ_PREFERENCE_METHOD -> {
                Log.d(TAG, "read")
                readPreferences()
            }
        }

        return null
    }

    private fun getStringPreference(): String {
        return prefs.getString(
            MyPreferences.SAVED_STRING_KEY,
            "default value"
        ) ?: ""
    }

    private fun putStringPreference(str: String) {
        with(prefs.edit()) {
            putString(
                MyPreferences.SAVED_STRING_KEY,
                str
            )
            commit()
        }
    }

    private fun savePreferences() {
        with(prefs.edit()) {
            putString(
                MyPreferences.SAVED_STRING_KEY,
                "test string!"
            )
            putBoolean(
                MyPreferences.SAVED_BOOLEAN_KEY,
                true
            )
            putInt(
                MyPreferences.SAVED_INT_KEY,
                1234567890
            )
            commit()
        }
    }

    private fun readPreferences() {

        val stringPreference = prefs.getString(
            MyPreferences.SAVED_STRING_KEY,
            "default value"
        )

        val booleanPreference = prefs.getBoolean(
            MyPreferences.SAVED_BOOLEAN_KEY,
            false
        )

        val intPreference = prefs.getInt(
            MyPreferences.SAVED_INT_KEY,
            0
        )

        Log.d(TAG, "string: {$stringPreference}")
        Log.d(TAG, "boolean: {$booleanPreference}")
        Log.d(TAG, "int: {$intPreference}")
    }
}
