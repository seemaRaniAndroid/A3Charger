package `in`.parangat.a3charger.Helper

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Connectivity.ApiServices
import `in`.parangat.a3charger.R
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.os.Build
import android.telephony.TelephonyManager
import android.text.InputFilter
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sparshclassesadvance.Network.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


fun TextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

fun BaseActivity.showShortToast(message: String) {
    android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
}

fun View.setDebounceClickListener(listener: View.OnClickListener, waitMillis: Long = 1000) {
    var lastClickTime = 0L
    setOnClickListener { view ->
        if (System.currentTimeMillis() > lastClickTime + waitMillis) {
            listener.onClick(view)
            lastClickTime = System.currentTimeMillis()
        }
    }
}

fun getIMEI(context: Context): String? {
    val mngr =
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_PHONE_STATE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
    }
    return mngr.deviceId
}

fun View.setAsBackButton() {
    if (this != null) {
        setOnClickListener {
            if (this.context is Activity) {
                var activity = this.getContext() as Activity

                activity.onBackPressed()
            }
        }
    }
}
/**
 * UNIX TIME FORMTAT
 * */
var unixTime = System.currentTimeMillis() / 1000L

/**
 * Api initialization
 * */
val apiService by lazy {
    ApiServices.create(AppConstants.BASE_URL)
}

/**
 * HASHMAP */
val hashMap: HashMap<String, Any> = HashMap()

val TAG = "------>>>>>>"

/**
 * Binding Images using Databinding
 * */
//@BindingAdapter("imageUrl", "placeholder")
//fun ImageView.loadImage(url: String, placeholder: Drawable) {
//    Picasso.get().load(url).placeholder(placeholder).into(this)
//}

/**
 * Go to New Activity using pending Transition
 * */
fun gotoActivity(context: Context,className: Class<*>?) {
    context.startActivity(Intent( context, className).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    })

    if (context is Activity) {
        context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}


fun setRecyclerView(recyclerView: RecyclerView, context: Context)
{
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    recyclerView.itemAnimator = DefaultItemAnimator()
}


fun setRecyclerViewHorizontal(recyclerView: RecyclerView, context: Context)
{
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
    recyclerView.itemAnimator = DefaultItemAnimator()
}
fun <R> CoroutineScope.executeAsyncTask(
    onPreExecute: () -> Unit,
    doInBackground: () -> R,
    onPostExecute: (R) -> Unit
) = launch {
    onPreExecute() // runs in Main Thread
    val result = withContext(Dispatchers.IO) {
        doInBackground() // runs in background thread without blocking the Main Thread
    }
    onPostExecute(result) // runs in Main Thread
}

fun <P, R> CoroutineScope.executeAsyncTask(
    onPreExecute: () -> Unit,
    doInBackground: suspend (suspend (P) -> Unit) -> R,
    onPostExecute: (R) -> Unit,
    onProgressUpdate: (P) -> Unit
) = launch {
    onPreExecute()

    val result = withContext(Dispatchers.IO) {
        doInBackground {
            withContext(Dispatchers.Main) { onProgressUpdate(it) }
        }
    }
    onPostExecute(result)
}



fun getTimeFormatted(timestamp: Long?): String {
    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp!!
        val sdf = SimpleDateFormat("EEEE,MMM dd,yyyy")
        val currenTimeZone = calendar.time as Date
        return sdf.format(currenTimeZone)
    } catch (e: Exception) {
    }

    return ""
}

fun getTimeInFormat(timestamp: Long?): String {
    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp!!
        val sdf = SimpleDateFormat("HH:mm:ss")
        val currenTimeZone = calendar.time as Date
        return sdf.format(currenTimeZone)
    } catch (e: Exception) {
    }

    return ""
}

fun getTimeInFormatForSlot(timestamp: Long?): String {
    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp!! * 1000
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val currenTimeZone = calendar.time as Date
        return sdf.format(currenTimeZone)
    } catch (e: Exception) {
    }

    return ""
}

fun View.resize(width: Int, height: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}


fun View.margin(left: Int, top: Int, right: Int, bottom: Int) {
    val lp = layoutParams

    lp?.let {
        layoutParams = lp
    }
}

fun getDay(d: String): String {
    val originalFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    val targetFormat: DateFormat = SimpleDateFormat("EEEE")
    val date: Date = originalFormat.parse(d)
    try {
        val formattedDate: String = targetFormat.format(date) // 20120821
        return formattedDate
    } catch (e: Exception) {
        return d
    }


}

fun getDate(d: String): String {
    val originalFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    val targetFormat: DateFormat = SimpleDateFormat("dd MMM yyyy")
    val date: Date = originalFormat.parse(d)
    try {
        val formattedDate: String = targetFormat.format(date) // 20120821
        return formattedDate
    } catch (e: Exception) {
        return d
    }

}

fun getMonthYear(d: String): String {
    val originalFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    val targetFormat: DateFormat = SimpleDateFormat("MMM, yyyy")
    val date: Date = originalFormat.parse(d)
    try {
        val formattedDate: String = targetFormat.format(date) // 20120821
        return formattedDate
    } catch (e: Exception) {
        return d
    }

}

fun EditText.setRightDrawable(id: Int) {
    setCompoundDrawablesWithIntrinsicBounds(0, 0, id, 0)
}

fun TextView.setLeftDrawable(id: Int) {
    setCompoundDrawablesWithIntrinsicBounds(id, 0, 0, 0)
}


fun EditText.disableSpace() {

    val spaceFilter = InputFilter { source, start, end, dest, dstart, dend ->

        var r: CharSequence? = null
        for (i in start..end - 1) {
            if (!Character.isLetterOrDigit(source[i])) {
                r = ""
            }
        }
        r
    }

    this.filters = arrayOf(spaceFilter)


}

fun EditText.isEmpty() {

}

fun BaseActivity.showLongToast(message: String) {
    android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
}

val Int.toPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Boolean.toInt: Int
    get() = if (this) 1 else 0


val String.isValidEmail: Boolean
    get() = if (this.length < 3 || this.length > 265)
        false
    else {
        this.matches(AppConstants.EMAIL_PATTERN.toRegex())
    }

val String.isValidMobile: Boolean
    get() = if (this.length >= 10)
        true
    else {
        false
    }

val String.isValidPassword: Boolean
    get() = if (this.length >= 8)
        true
    else {
        false
    }
/* get()=
     this.matches(Constant.PASSWORD_PATTERN.toRegex())*/



@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun transparentStatusBar() {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
        //window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);


// clear FLAG_TRANSLUCENT_STATUS flag:
        // window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        //   window.setStatusBarColor(ContextCompat.getColor(this, R.drawable.gradiant_bg));
    }
}

fun EditText.getString(): String {
    return this?.let {
        it.text.toString().trim()
    }

}

fun TextView.getString(): String {
    return this?.let { it.text.toString().trim() }
}

fun ImageView.setImageFromDevice(fileUri: String?) {
    fileUri?.let {
        val bmp = BitmapFactory.decodeFile(fileUri);
        setImageBitmap(bmp)
    }
}

fun ImageView.loadImage(
    imageUrl: Any?, isCenterCrop: Boolean = false,
    isCenterInside: Boolean = false,
    isRoundedCorners: Boolean = false,
    isCircleCrop: Boolean = false,
    roundingRadius: Int = 0.toInt(),

    placeholderResId: Any? = null,
    errorResId: Any? = null
) {
    val imageView = this


    if (imageUrl is String && imageUrl.isEmpty()) return

    /*GlideApp.with(context).load(imageUrl).apply {

        placeholderResId?.let {
            when (it) {
                is Drawable -> placeholder(it)
                is Int -> placeholder(it)
                else -> {
                }
            }
        }

        errorResId?.let {
            when (it) {
                is Drawable -> error(it)
                is Int -> error(it)
                else -> {
                }
            }

        }
        into(imageView)
    }*/
}



fun hideKeyboard(context: Context?) {
    if (context is Activity) {
        val focusedView = context.currentFocus
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            focusedView?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}
fun <T> List<T>.toArrayList(): ArrayList<T>{
    return ArrayList(this)
}

/**
 * Extension method to get the TAG name for all object
 */
fun <T : Any> T.TagName() = this::class.simpleName







