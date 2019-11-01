package space.msyaiful.getproduct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import space.msyaiful.getproduct2.Rest.ApiClient;
import space.msyaiful.getproduct2.Rest.ApiService;
import space.msyaiful.getproduct2.Rest.ApiUtil;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvlist;
    private RecyclerView rvlist2;
    private RecyclerView rvlist3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvlist2 = findViewById(R.id.rv_listproductbest);
        getProductBest(rvlist2);

        rvlist3 = findViewById(R.id.rv_listproductoffer);
        getProductOffer(rvlist3);

        rvlist = findViewById(R.id.rv_listproduct);
        getProduct(rvlist);
    }

        private void getProductBest(final RecyclerView rv){
        Retrofit ret = ApiClient.getClient(ApiUtil.Base_url);
        ApiService api = ret.create(ApiService.class);

        Call<ArrayList<DataProductBest>> db = api.getProductBest();
        db.enqueue(new Callback<ArrayList<DataProductBest>>() {
            @Override
            public void onResponse(Call<ArrayList<DataProductBest>> call, Response<ArrayList<DataProductBest>> response) {
                ProductBestAdapter productBestAdapter = new ProductBestAdapter(MainActivity.this, response.body());
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(productBestAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DataProductBest>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }

        private void getProductOffer(final RecyclerView reVi){
        Retrofit rt = ApiClient.getClient(ApiUtil.Base_url);
        ApiService as = rt.create(ApiService.class);

        Call<ArrayList<DataProductOffer>> dof = as.getProductOffer();
        dof.enqueue(new Callback<ArrayList<DataProductOffer>>() {
            @Override
            public void onResponse(Call<ArrayList<DataProductOffer>> call, Response<ArrayList<DataProductOffer>> response) {
                ProductOfferAdapter productOfferAdapter = new ProductOfferAdapter(MainActivity.this, response.body());
                reVi.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                reVi.setAdapter(productOfferAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DataProductOffer>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }

    private void getProduct(final RecyclerView recyclerView){
        Retrofit retrofit = ApiClient.getClient(ApiUtil.Base_url);
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<DataProduct>> data = apiService.getProduct();
        data.enqueue(new Callback<ArrayList<DataProduct>>() {
            @Override
            public void onResponse(Call<ArrayList<DataProduct>> call, Response<ArrayList<DataProduct>> response) {
                ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, response.body());
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DataProduct>> call, Throwable t) {
                Log.e("ERROR", t.getMessage() );
            }
        });
    }
}
