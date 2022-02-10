package in.parangat.a3charger.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J2\u0010\u001a\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020#J\u0016\u0010$\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\r\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lin/parangat/a3charger/viewmodel/PendingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "list", "Ljava/util/ArrayList;", "Lin/parangat/a3charger/model/VenueDataItem;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "mList", "Landroidx/lifecycle/MutableLiveData;", "getMList", "()Landroidx/lifecycle/MutableLiveData;", "setMList", "(Landroidx/lifecycle/MutableLiveData;)V", "progressDialog", "Lin/parangat/a3charger/Helper/SingleLiveEvent;", "", "getProgressDialog", "()Lin/parangat/a3charger/Helper/SingleLiveEvent;", "setProgressDialog", "(Lin/parangat/a3charger/Helper/SingleLiveEvent;)V", "dashboardData", "userId", "", "status", "onFailure", "", "it", "", "onSuccess", "Lin/parangat/a3charger/model/VenueResponse;", "prepareDashboard", "app_debug"})
public final class PendingViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.Nullable()
    private androidx.lifecycle.MutableLiveData<java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem>> mList;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem> list;
    @org.jetbrains.annotations.Nullable()
    private in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> progressDialog;
    
    public PendingViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem>> getMList() {
        return null;
    }
    
    public final void setMList(@org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.Nullable()
    in.parangat.a3charger.Helper.SingleLiveEvent<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<in.parangat.a3charger.model.VenueDataItem>> dashboardData(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
        return null;
    }
    
    public final void prepareDashboard(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
    }
    
    public final void onSuccess(@org.jetbrains.annotations.NotNull()
    in.parangat.a3charger.model.VenueResponse it) {
    }
    
    public final void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable it) {
    }
}