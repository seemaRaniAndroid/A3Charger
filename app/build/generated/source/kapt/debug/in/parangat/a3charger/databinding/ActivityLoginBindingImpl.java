package in.parangat.a3charger.databinding;
import in.parangat.a3charger.R;
import in.parangat.a3charger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements in.parangat.a3charger.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.label_1, 4);
        sViewsWithIds.put(R.id.show_pass_btn, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener editPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginmodel.password.get()
            //         is loginmodel.password.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editPassword);
            // localize variables for thread safety
            // loginmodel.password.get()
            java.lang.String loginmodelPasswordGet = null;
            // loginmodel.password
            androidx.databinding.ObservableField<java.lang.String> loginmodelPassword = null;
            // loginmodel
            in.parangat.a3charger.viewmodel.LoginViewModel loginmodel = mLoginmodel;
            // loginmodel != null
            boolean loginmodelJavaLangObjectNull = false;
            // loginmodel.password != null
            boolean loginmodelPasswordJavaLangObjectNull = false;



            loginmodelJavaLangObjectNull = (loginmodel) != (null);
            if (loginmodelJavaLangObjectNull) {


                loginmodelPassword = loginmodel.getPassword();

                loginmodelPasswordJavaLangObjectNull = (loginmodelPassword) != (null);
                if (loginmodelPasswordJavaLangObjectNull) {




                    loginmodelPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener emailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginmodel.email.get()
            //         is loginmodel.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(email);
            // localize variables for thread safety
            // loginmodel.email
            androidx.databinding.ObservableField<java.lang.String> loginmodelEmail = null;
            // loginmodel
            in.parangat.a3charger.viewmodel.LoginViewModel loginmodel = mLoginmodel;
            // loginmodel != null
            boolean loginmodelJavaLangObjectNull = false;
            // loginmodel.email != null
            boolean loginmodelEmailJavaLangObjectNull = false;
            // loginmodel.email.get()
            java.lang.String loginmodelEmailGet = null;



            loginmodelJavaLangObjectNull = (loginmodel) != (null);
            if (loginmodelJavaLangObjectNull) {


                loginmodelEmail = loginmodel.getEmail();

                loginmodelEmailJavaLangObjectNull = (loginmodelEmail) != (null);
                if (loginmodelEmailJavaLangObjectNull) {




                    loginmodelEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (in.parangat.a3charger.fontclass.SemiBoldTextView) bindings[2]
            , (in.parangat.a3charger.fontclass.ET_Edittext) bindings[3]
            , (in.parangat.a3charger.fontclass.ET_Edittext) bindings[1]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (android.widget.ImageView) bindings[5]
            );
        this.btnLogin.setTag(null);
        this.editPassword.setTag(null);
        this.email.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new in.parangat.a3charger.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.loginmodel == variableId) {
            setLoginmodel((in.parangat.a3charger.viewmodel.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginmodel(@Nullable in.parangat.a3charger.viewmodel.LoginViewModel Loginmodel) {
        this.mLoginmodel = Loginmodel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.loginmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginmodelEmail((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLoginmodelPassword((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginmodelEmail(androidx.databinding.ObservableField<java.lang.String> LoginmodelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginmodelPassword(androidx.databinding.ObservableField<java.lang.String> LoginmodelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.databinding.ObservableField<java.lang.String> loginmodelEmail = null;
        java.lang.String loginmodelEmailGet = null;
        java.lang.String loginmodelPasswordGet = null;
        androidx.databinding.ObservableField<java.lang.String> loginmodelPassword = null;
        in.parangat.a3charger.viewmodel.LoginViewModel loginmodel = mLoginmodel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (loginmodel != null) {
                        // read loginmodel.email
                        loginmodelEmail = loginmodel.getEmail();
                    }
                    updateRegistration(0, loginmodelEmail);


                    if (loginmodelEmail != null) {
                        // read loginmodel.email.get()
                        loginmodelEmailGet = loginmodelEmail.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (loginmodel != null) {
                        // read loginmodel.password
                        loginmodelPassword = loginmodel.getPassword();
                    }
                    updateRegistration(1, loginmodelPassword);


                    if (loginmodelPassword != null) {
                        // read loginmodel.password.get()
                        loginmodelPasswordGet = loginmodelPassword.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnLogin.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editPasswordandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.email, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, emailandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editPassword, loginmodelPasswordGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.email, loginmodelEmailGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // loginmodel
        in.parangat.a3charger.viewmodel.LoginViewModel loginmodel = mLoginmodel;
        // loginmodel != null
        boolean loginmodelJavaLangObjectNull = false;



        loginmodelJavaLangObjectNull = (loginmodel) != (null);
        if (loginmodelJavaLangObjectNull) {


            loginmodel.getUserLogin();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginmodel.email
        flag 1 (0x2L): loginmodel.password
        flag 2 (0x3L): loginmodel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}