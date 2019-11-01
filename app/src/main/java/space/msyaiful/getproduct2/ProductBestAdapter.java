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


public class ProductBestAdapter extends RecyclerView.Adapter<ProductBestAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DataProductBest> ProductBestList;

    public ProductBestAdapter(Context context, ArrayList<DataProductBest> ProductBestList){
        inflater = LayoutInflater.from(context);
        this.ProductBestList = ProductBestList;
    }

    @NonNull
    @Override
    public  ProductBestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = inflater.inflate(R.layout.list_productbest, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductBestAdapter.ViewHolder viewHolder, final int pb) {

        viewHolder.nama_pro2.setText(ProductBestList.get(pb).getNama_produk());
        viewHolder.deskripsi_pro2.setText(ProductBestList.get(pb).getDeskripsi());
        viewHolder.harga_pro2.setText(ProductBestList.get(pb).getHarga());
        viewHolder.nagara_pro2.setText(ProductBestList.get(pb).getNama_negara());
        Glide.with(viewHolder.itemView.getContext())
                .load("http://192.168.100.7:1997/"+ProductBestList.get(pb).getGambar())
                .apply(new RequestOptions().override(100, 100))
                .into(viewHolder.gambar_pro2);

    }

    @Override
    public int getItemCount(){return ProductBestList.size();}
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nama_pro2, deskripsi_pro2, harga_pro2, nagara_pro2;
        ImageView gambar_pro2;
        CardView detail_pro2;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            nama_pro2 = itemView.findViewById(R.id.nama_product2);
            deskripsi_pro2 = itemView.findViewById(R.id.deskripsi_product2);
            harga_pro2 = itemView.findViewById(R.id.harga_product2);
            nagara_pro2 = itemView.findViewById(R.id.nama_negara2);
            gambar_pro2 = itemView.findViewById(R.id.gambar_product2);
            detail_pro2 = itemView.findViewById(R.id.detail_productbest);

        }

    }
}
