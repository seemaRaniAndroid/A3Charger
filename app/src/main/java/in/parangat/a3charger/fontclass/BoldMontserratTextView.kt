package `in`.parangat.a3charger.fontclass

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class BoldMontserratTextView : AppCompatTextView {

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    constructor(context: Context?) : super(context!!) {
        init()
    }

    private fun init() {
        val tf = Typeface.createFromAsset(context.assets, "fonts/Montserrat-Bold.ttf")
        typeface = tf
    }
}