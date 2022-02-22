package azouay.mouad.app.services;

import java.util.List;

import azouay.mouad.app.pojos.Driver;
import azouay.mouad.app.pojos.ListDrivers;
import azouay.mouad.app.pojos.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    public static final String ENDPOINT = "https://busin.fr";

    @GET("/photos")
    Call<List<Photo>>  listPhotos();

    @GET("/drivers.json")
    Call<List<ListDrivers>>  listDrivers();



   /* @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);*/

}
