package in.parangat.a3charger.Connectivity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ8\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u0007H\'J8\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0007H\'\u00a8\u0006\u000f"}, d2 = {"Lin/parangat/a3charger/Connectivity/ApiServices;", "", "getPendingList", "Lio/reactivex/Observable;", "Lin/parangat/a3charger/model/VenueResponse;", "headers", "", "", "user_id", "status", "getUserLogin", "Lin/parangat/a3charger/model/BasicResponse;", "username", "pass", "Companion", "app_debug"})
public abstract interface ApiServices {
    @org.jetbrains.annotations.NotNull()
    public static final in.parangat.a3charger.Connectivity.ApiServices.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmSuppressWildcards()
    @retrofit2.http.POST(value = "rider/login")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<in.parangat.a3charger.model.BasicResponse> getUserLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.HeaderMap()
    java.util.Map<java.lang.String, java.lang.Object> headers, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String pass);
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmSuppressWildcards()
    @retrofit2.http.POST(value = "rider/venueList")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<in.parangat.a3charger.model.VenueResponse> getPendingList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.HeaderMap()
    java.util.Map<java.lang.String, java.lang.Object> headers, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "status")
    java.lang.String status);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lin/parangat/a3charger/Connectivity/ApiServices$Companion;", "", "()V", "create", "Lin/parangat/a3charger/Connectivity/ApiServices;", "baseUrl", "", "connectTimeoutInSec", "", "readTimeoutInSec", "writeTimeoutInSec", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final in.parangat.a3charger.Connectivity.ApiServices create(@org.jetbrains.annotations.NotNull()
        java.lang.String baseUrl, long connectTimeoutInSec, long readTimeoutInSec, long writeTimeoutInSec) {
            return null;
        }
    }
}