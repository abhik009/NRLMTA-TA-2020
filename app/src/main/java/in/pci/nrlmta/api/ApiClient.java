package in.pci.nrlmta.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit adapter = null;
    private static final String BASE_URL = "https://api.ona.io/api/v1/";
    public static Retrofit getClient() {
        if (adapter == null) {
            adapter = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return adapter;
    }
}
