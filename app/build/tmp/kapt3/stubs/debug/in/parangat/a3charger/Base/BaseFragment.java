package in.parangat.a3charger.Base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lin/parangat/a3charger/Base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "prefs", "Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "getPrefs", "()Lin/parangat/a3charger/Database/SharedPreferenceUtil;", "prefs$delegate", "Lkotlin/Lazy;", "progressDialog", "Lin/parangat/a3charger/Helper/CustomProgress;", "getProgressDialog", "()Lin/parangat/a3charger/Helper/CustomProgress;", "progressDialog$delegate", "init", "", "initControl", "app_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy progressDialog$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy prefs$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final in.parangat.a3charger.Helper.CustomProgress getProgressDialog() {
        return null;
    }
    
    public abstract void init();
    
    public abstract void initControl();
    
    @org.jetbrains.annotations.NotNull()
    public final in.parangat.a3charger.Database.SharedPreferenceUtil getPrefs() {
        return null;
    }
}