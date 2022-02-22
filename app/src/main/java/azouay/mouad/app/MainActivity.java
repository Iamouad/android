package azouay.mouad.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import azouay.mouad.app.pojos.Driver;
import azouay.mouad.app.pojos.ListDrivers;
import azouay.mouad.app.pojos.Photo;
import azouay.mouad.app.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiService service;
    List<ListDrivers> drivers;
    RecyclerView rvDrivers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDrivers = findViewById(R.id.recyclerDriver);
        rvDrivers.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        service = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        service.listDrivers().enqueue(new Callback<List<ListDrivers>>() {
            @Override
            public void onResponse(Call<List<ListDrivers>> call, Response<List<ListDrivers>> response) {
                drivers = response.body();
                System.out.println("Getting pos" + drivers.get(0).getPosition());

                System.out.println("Getting name" + drivers.get(0).getDriver().getName());
                System.out.println("ressssssss" + drivers.size());
                DriverAdapter adapter = new DriverAdapter(drivers);
                rvDrivers.setAdapter(adapter);
                MainActivity.this.setTitle("List drivers");
            }

            @Override
            public void onFailure(Call<List<ListDrivers>> call, Throwable t) {
                System.out.println("errrrrrrrr" + t.getMessage());
            }
        });
        /*rvPhotos = findViewById(R.id.recyclerPhoto);
        rvPhotos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        service = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);

        service.listPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photos = response.body();
                System.out.println("photos..........." + photos.size());
                PhotoAdapter adapter = new PhotoAdapter(photos);
                rvPhotos.setAdapter(adapter);
                MainActivity.this.setTitle("Tst");
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                System.out.println("errrrrrrrrrr"+t.getMessage());
            }
        });*/
    }


}