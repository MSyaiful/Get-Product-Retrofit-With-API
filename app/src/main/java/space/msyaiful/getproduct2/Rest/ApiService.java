package space.msyaiful.getproduct2.Rest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import space.msyaiful.getproduct2.DataProduct;
import space.msyaiful.getproduct2.DataProductBest;
import space.msyaiful.getproduct2.DataProductOffer;

public interface ApiService {

//    @GET("transaction/curency")
//    Call<ArrayList<Data>> getTransaction();

    @GET("product/getproduct")
    Call<ArrayList<DataProduct>> getProduct();

    @GET("product/getproductbest")
    Call<ArrayList<DataProductBest>> getProductBest();

    @GET("product/getproductoffer")
    Call<ArrayList<DataProductOffer>> getProductOffer();
}
