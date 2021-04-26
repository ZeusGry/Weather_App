package request;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RequestOpenWeatherMap {
    private static final String URL = "api.openweathermap.org/data/2.5/weather?lat=Latination&lon=Longitude&units=metric&appid=8a6fa744d602a1ed0757c5b717b29e3f";


    public void response() throws IOException {


        Request request = new Request.Builder()
                .url(URL)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

}
