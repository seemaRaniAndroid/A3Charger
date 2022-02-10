package `in`.parangat.a3charger.Database

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.sparshclassesadvance.Network.AppConstants

class SharedPreferenceUtil private constructor(val context: Context) {
    val TAG = SharedPreferenceUtil::class.java.simpleName

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(AppConstants.PREFRENCE_NAME, Context.MODE_PRIVATE)
    private val persistableSharedPreferences: SharedPreferences = context.getSharedPreferences(
        AppConstants.PERSISTABLE_PREFRENCE_NAME, Context.MODE_PRIVATE
    )
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var instance: SharedPreferenceUtil? = null

        fun getInstance(ctx: Context): SharedPreferenceUtil {
            if (instance == null) {
                instance = SharedPreferenceUtil(ctx)
            }
            return instance!!
        }
    }

    var fcmToken: String?
        get() = sharedPreferences["fcmToken", ""]!!
        set(value) = sharedPreferences.set("fcmToken", value)

    var authToken: String?
        get() = sharedPreferences["authToken", ""]!!
        set(value) = sharedPreferences.set("authToken", value)

    var userID: String?
        get() = sharedPreferences["userID", ""]!!
        set(value) = sharedPreferences.set("userID", value)

    var userName: String?
        get() = sharedPreferences["userName", ""]!!
        set(value) = sharedPreferences.set("userName", value)

    var userEmail: String?
        get() = sharedPreferences["userEmail", ""]!!
        set(value) = sharedPreferences.set("userEmail", value)

    var userPhoneNumber: String?
        get() = sharedPreferences["userPhoneNumber", ""]!!
        set(value) = sharedPreferences.set("userPhoneNumber", value)
//
//    fun saveUserBeanResponse(userBean: UserDataItem) {
//
//    }


    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit({ it.putString(key, value) })
            is Int -> edit({ it.putInt(key, value) })
            is Boolean -> edit({ it.putBoolean(key, value) })
            is Float -> edit({ it.putFloat(key, value) })
            is Long -> edit({ it.putLong(key, value) })
            else -> Log.e(TAG, "Setting shared pref failed for key: $key and value: $value ")
        }
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    /**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1
     * for numeric values if [defaultValue] is not specified
     */
    inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    fun deletePreferences() {
        editor.clear()
        editor.apply()
    }

    fun clear(key: String?) {
        editor.remove(key).apply()
    }


}