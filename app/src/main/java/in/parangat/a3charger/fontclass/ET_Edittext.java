package in.parangat.a3charger.fontclass;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

public class ET_Edittext extends AppCompatEditText {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public ET_Edittext(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ET_Edittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public ET_Edittext(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/NunitoSans-SemiBold.ttf");
        this.setTypeface(font);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/NunitoSans-SemiBold.ttf");
        super.setTypeface(tf, style);
    }


    @Override
    public void setTypeface(Typeface tf) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/NunitoSans-SemiBold.ttf");
        super.setTypeface(tf);
    }
}