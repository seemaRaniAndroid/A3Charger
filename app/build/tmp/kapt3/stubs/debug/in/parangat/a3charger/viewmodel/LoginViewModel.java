package in.parangat.a3charger.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0007J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0007R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u0006/"}, d2 = {"Lin/parangat/a3charger/viewmodel/LoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "basicResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/parangat/a3charger/model/BasicResponse;", "getBasicResponse", "()Landroidx/lifecycle/MutableLiveData;", "setBasicResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "btnSelected", "Landroidx/databinding/ObservableBoolean;", "getBtnSelected", "()Landroidx/databinding/ObservableBoolean;", "setBtnSelected", "(Landroidx/databinding/ObservableBoolean;)V", "email", "Landroidx/databinding/ObservableField;", "", "getEmail", "()Landroidx/databinding/ObservableField;", "setEmail", "(Landroidx/databinding/ObservableField;)V", "password", "getPassword", "setPassword", "prefs", "Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "getPrefs", "()Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "prefs$delegate", "Lkotlin/Lazy;", "progressDialog", "Lin/parangat/a3charger/Helper/SingleLiveEvent;", "", "getProgressDialog", "()Lin/parangat/a3charger/Helper/SingleLiveEvent;", "setProgressDialog", "(Lin/parangat/a3charger/Helper/SingleLiveEvent;)V", "getUserLogin", "", "onFailure", "it", "", "onSuccess", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.Nullable()
    private androidx.databinding.ObservableBoolean btnSelected;
    @org.jetbrains.annotations.Nullable()
    private androidx.databinding.ObservableField<java.lang.String> email;
    @org.jetbrains.annotations.Nullable()
    private androidx.databinding.ObservableField<java.lang.String> password;
    @org.jetbrains.annotations.Nullable()
    private in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> progressDialog;
    @org.jetbrains.annotations.Nullable()
    private androidx.lifecycle.MutableLiveData<in.parangat.a3charger.model.BasicResponse> basicResponse;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy prefs$delegate = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.databinding.ObservableBoolean getBtnSelected() {
        return null;
    }
    
    public final void setBtnSelected(@org.jetbrains.annotations.Nullable()
    androidx.databinding.ObservableBoolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.databinding.ObservableField<java.lang.String> getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.databinding.ObservableField<java.lang.String> getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.Nullable()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.Nullable()
    in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<in.parangat.a3charger.model.BasicResponse> getBasicResponse() {
        return null;
    }
    
    public final void setBasicResponse(@org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<in.parangat.a3charger.model.BasicResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final in.parangat.a3charger.Database.SharedPreferenceUtil getPrefs() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void getUserLogin() {
    }
    
    public final void onSuccess(@org.jetbrains.annotations.NotNull()
    in.parangat.a3charger.model.BasicResponse it) {
    }
    
    public final void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable it) {
    }
}