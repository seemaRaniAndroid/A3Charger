package in.parangat.a3charger.Helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lin/parangat/a3charger/Helper/CustomProgress;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCtx$app_debug", "()Landroid/content/Context;", "setCtx$app_debug", "isShowing", "", "()Z", "progress", "Landroid/app/ProgressDialog;", "getProgress$app_debug", "()Landroid/app/ProgressDialog;", "setProgress$app_debug", "(Landroid/app/ProgressDialog;)V", "hideProgress", "", "showProgress", "msg", "", "app_debug"})
public final class CustomProgress {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context ctx;
    @org.jetbrains.annotations.Nullable()
    private android.app.ProgressDialog progress;
    
    public CustomProgress(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getCtx$app_debug() {
        return null;
    }
    
    public final void setCtx$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.ProgressDialog getProgress$app_debug() {
        return null;
    }
    
    public final void setProgress$app_debug(@org.jetbrains.annotations.Nullable()
    android.app.ProgressDialog p0) {
    }
    
    public final boolean isShowing() {
        return false;
    }
    
    public final void showProgress() {
    }
    
    public final void showProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void hideProgress() {
    }
}