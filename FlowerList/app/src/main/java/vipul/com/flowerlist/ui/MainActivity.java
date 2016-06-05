package vipul.com.flowerlist.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import vipul.com.flowerlist.R;
import vipul.com.flowerlist.adapter.FlowersAdapter;
import vipul.com.flowerlist.model.FlowersCollection;
import vipul.com.flowerlist.web.adapter.FlowerWebAdapter;
import vipul.com.flowerlist.web.service.FlowerService;


public class MainActivity extends AppCompatActivity {

    private ListView flowersList;
    private FlowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowersList = (ListView) findViewById(R.id.flowersList);

        FlowerService flowerService = new FlowerWebAdapter().getFlowerService();
        flowerService.getFlowerList("2", new Callback<FlowersCollection>() {
            @Override
            public void success(FlowersCollection flowersCollection, Response response) {
                adapter = new FlowersAdapter(MainActivity.this, flowersCollection.flowers);
                flowersList.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
}
