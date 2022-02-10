package in.parangat.a3charger.Base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000fH&J\b\u0010\u0017\u001a\u00020\u000fH&J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\""}, d2 = {"Lin/parangat/a3charger/Base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "prefs", "Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "getPrefs", "()Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "prefs$delegate", "Lkotlin/Lazy;", "progressDialog", "Lin/parangat/a3charger/Helper/CustomProgress;", "getProgressDialog", "()Lin/parangat/a3charger/Helper/CustomProgress;", "progressDialog$delegate", "changeStatusBarColor", "", "color", "", "createPartFromString", "Lokhttp3/RequestBody;", "descriptionString", "", "init", "initControl", "isInternetAvailable", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy progressDialog$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final in.parangat.a3charger.Database.SharedPreferenceUtil getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final in.parangat.a3charger.Helper.CustomProgress getProgressDialog() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void changeStatusBarColor(int color) {
    }
    
    public final boolean isInternetAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public abstract void init();
    
    public abstract void initControl();
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.RequestBody createPartFromString(@org.jetbrains.annotations.NotNull()
    java.lang.String descriptionString) {
        return null;
    }
}