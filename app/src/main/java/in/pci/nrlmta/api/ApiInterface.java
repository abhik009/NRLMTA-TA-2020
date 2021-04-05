package in.pci.nrlmta.api;

import java.util.List;

import in.pci.nrlmta.models.BaseDataModel;
import in.pci.nrlmta.models.BlockDataModel;
import in.pci.nrlmta.models.StateDataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("data/513624") // sub url for our base url
    Call<List<StateDataModel>> getStateData();

    @GET("data/585485") // sub url for our base url
    Call<List<BlockDataModel>> getBlockData();

    @GET("data/515504") // sub url for our base url
    Call<List<BaseDataModel>> getBaseData();
}
