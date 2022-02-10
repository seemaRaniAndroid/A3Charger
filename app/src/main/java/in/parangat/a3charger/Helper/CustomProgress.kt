package `in`.parangat.a3charger.Helper

import android.app.ProgressDialog
import android.content.Context

class CustomProgress(internal var ctx: Context) {

    internal var progress: ProgressDialog? = null

    val isShowing: Boolean
        get() = progress!!.isShowing

    init {
        progress = ProgressDialog(ctx)
        progress!!.setMessage("Please Wait")
        progress!!.setCancelable(false)
    }

    fun showProgress() {
        progress!!.show()
    }

    fun showProgress(msg: String) {
        progress!!.setMessage("" + msg)
        progress!!.show()
    }



    fun hideProgress() {
        if (progress != null && progress!!.isShowing) {
            try {
                progress!!.hide()
                progress!!.dismiss()
            }catch (e : Exception){

            }

        }
    }

}
