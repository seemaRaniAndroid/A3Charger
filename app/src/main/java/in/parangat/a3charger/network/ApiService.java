package in.parangat.a3charger.network;


import in.parangat.a3charger.model.ReceeResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @Headers({"time:1602487422",
            "hash:3d3607b6ef6850bc98681d2ebc10e42a",
            "ocode:korea",
            "openid:n5dvamlpn25slmOc"})
    @POST("rider/addRecce")
    Call<ReceeResponse> getReceeData(@Field("venue_id") String venue_id,
                                     @Field("number_of_outlets") String number_of_outlets,
                                     @Field("address") String address,
                                     @Field("contact") String contact,
                                     @Field("footfall") String footfall,
                                     @Field("no_of_employees") String no_of_employees,
                                     @Field("slots") String slots,
                                     @Field("nearest_distance") String nearest_distance,
                                     @Field("is_suitable") String is_suitable,
                                     @Field("date") String date,
                                     @Field("remarks") String remarks);


}
