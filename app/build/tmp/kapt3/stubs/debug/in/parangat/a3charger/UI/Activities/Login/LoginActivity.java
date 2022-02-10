package in.parangat.a3charger.UI.Activities.Login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0014J-\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0012H\u0002J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lin/parangat/a3charger/UI/Activities/Login/LoginActivity;", "Lin/parangat/a3charger/Base/BaseActivity;", "()V", "PERMISSION_WRITE", "", "getPERMISSION_WRITE", "()I", "STORAGE_PERMISSION_CODE", "getSTORAGE_PERMISSION_CODE", "activityLoginBinding", "Lin/parangat/a3charger/databinding/ActivityLoginBinding;", "activityScope", "Lkotlinx/coroutines/CoroutineScope;", "loginViewModel", "Lin/parangat/a3charger/viewmodel/LoginViewModel;", "checkPermission", "", "init", "", "initControl", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestStoragePermission", "showHidPass", "view", "Landroid/view/View;", "app_debug"})
public final class LoginActivity extends in.parangat.a3charger.Base.BaseActivity {
    private in.parangat.a3charger.databinding.ActivityLoginBinding activityLoginBinding;
    private in.parangat.a3charger.viewmodel.LoginViewModel loginViewModel;
    private final kotlinx.coroutines.CoroutineScope activityScope = null;
    private final int PERMISSION_WRITE = 0;
    private final int STORAGE_PERMISSION_CODE = 198;
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    public final int getPERMISSION_WRITE() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void init() {
    }
    
    @java.lang.Override()
    public void initControl() {
    }
    
    public final void showHidPass(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public final boolean checkPermission() {
        return false;
    }
    
    public final int getSTORAGE_PERMISSION_CODE() {
        return 0;
    }
    
    private final void requestStoragePermission() {
    }
}