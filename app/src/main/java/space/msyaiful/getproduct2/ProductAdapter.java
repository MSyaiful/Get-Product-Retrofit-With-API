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


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DataProduct> ProductList;

    public ProductAdapter(Context context, ArrayList<DataProduct> ProductList){
        inflater = LayoutInflater.from(context);
        this.ProductList = ProductList;
    }

    @NonNull
    @Override
    public  ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = inflater.inflate(R.layout.list_product, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder viewHolder, final int pb) {

        viewHolder.nama_pro.setText(ProductList.get(pb).getNama_produk());
        viewHolder.deskripsi_pro.setText(ProductList.get(pb).getDeskripsi());
        viewHolder.harga_pro.setText(ProductList.get(pb).getHarga());
        viewHolder.nagara_pro.setText(ProductList.get(pb).getNama_negara());
        Glide.with(viewHolder.itemView.getContext())
                .load("http://192.168.100.7:1997/"+ProductList.get(pb).getGambar())
                .apply(new RequestOptions().override(100, 100))
                .into(viewHolder.gambar_pro);

    }

    @Override
    public int getItemCount(){return ProductList.size();}
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nama_pro, deskripsi_pro, harga_pro, nagara_pro;
        ImageView gambar_pro;
        CardView detail_pro;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            nama_pro = itemView.findViewById(R.id.nama_product);
            deskripsi_pro = itemView.findViewById(R.id.deskripsi_product);
            harga_pro = itemView.findViewById(R.id.harga_product);
            nagara_pro = itemView.findViewById(R.id.nama_negara);
            gambar_pro = itemView.findViewById(R.id.gambar_product);
            detail_pro = itemView.findViewById(R.id.detail_product);

        }

    }
}
