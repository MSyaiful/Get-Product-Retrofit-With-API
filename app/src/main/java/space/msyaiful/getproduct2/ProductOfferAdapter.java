package space.msyaiful.getproduct2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class ProductOfferAdapter extends RecyclerView.Adapter<ProductOfferAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DataProductOffer> ProductOfferList;

    public ProductOfferAdapter(Context context, ArrayList<DataProductOffer> ProductOfferList){
        inflater = LayoutInflater.from(context);
        this.ProductOfferList = ProductOfferList;
    }

    @NonNull
    @Override
    public  ProductOfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = inflater.inflate(R.layout.list_productoffer, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductOfferAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.nama_pro3.setText(ProductOfferList.get(i).getNama_produk());
        viewHolder.deskripsi_pro3.setText(ProductOfferList.get(i).getDeskripsi());
        viewHolder.harga_pro3.setText(ProductOfferList.get(i).getHarga());
        viewHolder.nagara_pro3.setText(ProductOfferList.get(i).getNama_negara());
        Glide.with(viewHolder.itemView.getContext())
                .load("http://192.168.100.7:1997/"+ProductOfferList.get(i).getGambar())
                .apply(new RequestOptions().override(100, 100))
                .into(viewHolder.gambar_pro3);

    }

    @Override
    public int getItemCount(){return ProductOfferList.size();}
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nama_pro3, deskripsi_pro3, harga_pro3, nagara_pro3;
        ImageView gambar_pro3;
        CardView detail_pro3;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            nama_pro3 = itemView.findViewById(R.id.nama_product3);
            deskripsi_pro3 = itemView.findViewById(R.id.deskripsi_product3);
            harga_pro3 = itemView.findViewById(R.id.harga_product3);
            nagara_pro3 = itemView.findViewById(R.id.nama_negara3);
            gambar_pro3 = itemView.findViewById(R.id.gambar_product3);
            detail_pro3 = itemView.findViewById(R.id.detail_productoffer);

        }

    }
}

