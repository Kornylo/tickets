import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/owner")
    Call<User> owner();
}
