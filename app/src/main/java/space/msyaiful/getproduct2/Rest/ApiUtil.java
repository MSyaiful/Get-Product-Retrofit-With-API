package space.msyaiful.getproduct2.Rest;

public class ApiUtil {

    public ApiUtil(){

    }

    public static final String Base_url = "http://192.168.100.11:1997/";

    public static ApiService getProductService(){
        return ApiClient.getClient(Base_url).create(ApiService.class);
    }
}
