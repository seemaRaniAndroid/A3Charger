package `in`.parangat.a3charger.UI.Activities.Login

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.ActivityLoginBinding
import `in`.parangat.a3charger.viewmodel.LoginViewModel
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity() {
    private var activityLoginBinding: ActivityLoginBinding? = null
    private var loginViewModel: LoginViewModel? = null
    private val activityScope = CoroutineScope(Dispatchers.Main)
    val PERMISSION_WRITE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        activityLoginBinding?.loginmodel = loginViewModel

        activityScope.launch {
            checkPermission()
            requestStoragePermission()
            initControl()
            init()
        }

    }

    override fun init() {
        loginViewModel?.progressDialog?.observe(this) {
            if (it!!) {
                progressDialog.showProgress()
            } else {
                progressDialog.hideProgress()
            }
        }
    }

    override fun initControl() {

    }


    fun showHidPass(view: View) {
        if (view.id == R.id.show_pass_btn) {
            if (edit_password.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                edit_password.transformationMethod = HideReturnsTransformationMethod.getInstance();
                show_pass_btn.setImageResource(R.drawable.eye_open)
                edit_password.setSelection(edit_password.text!!.length)
            } else {
                show_pass_btn.setImageResource(R.drawable.eye_close)
                edit_password.transformationMethod = PasswordTransformationMethod.getInstance();
                edit_password.setSelection(edit_password.text!!.length)
            }
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_WRITE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //do somethings
        }
    }

    fun checkPermission(): Boolean {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA,
                    Manifest.permission.MANAGE_EXTERNAL_STORAGE
                ),
                1
            )
        }
        val READ_EXTERNAL_PERMISSION =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PERMISSION_WRITE
            )
            return false
        }
        return true
    }

    val STORAGE_PERMISSION_CODE = 198

    private fun requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) return
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            STORAGE_PERMISSION_CODE
        )
    }
}