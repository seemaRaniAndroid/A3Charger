package in.parangat.a3charger.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import in.parangat.a3charger.Base.BaseActivity;
import in.parangat.a3charger.R;
import in.parangat.a3charger.UI.Activities.Login.LoginActivity;

public class SubmittedSuccessfully extends BaseActivity implements View.OnClickListener {
    ImageView header_power;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted_successfully);
        init();
    }

    @Override
    public void init() {
        header_power = findViewById(R.id.header_power);
        header_power.setOnClickListener(this);
    }

    @Override
    public void initControl() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.header_power:
                getPrefs().deletePreferences();
                Intent intent = new Intent(SubmittedSuccessfully.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;


        }
    }
}
