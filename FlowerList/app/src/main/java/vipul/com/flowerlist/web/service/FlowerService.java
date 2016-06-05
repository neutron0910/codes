package vipul.com.flowerlist.web.service;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import vipul.com.flowerlist.model.FlowersCollection;

public interface FlowerService {
    @GET("/coGUFiJJmG")
    void getFlowerList(@Query("indent") String indent,
                       Callback<FlowersCollection> callback);
}
