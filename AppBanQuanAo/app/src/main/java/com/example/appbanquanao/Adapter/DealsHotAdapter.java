package com.example.appbanquanao.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Model.DealsHotModel;
import com.example.appbanquanao.R;

import java.util.List;

public class DealsHotAdapter extends RecyclerView.Adapter<DealsHotAdapter.ViewHolder> {
    private List<DealsHotModel> lstDealsHotModels;

    public DealsHotAdapter(List<DealsHotModel> lstDealsHotModels) {
        this.lstDealsHotModels = lstDealsHotModels;
    }

    @NonNull
    @Override
    public DealsHotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_hot_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsHotAdapter.ViewHolder holder, int position) {
        int resource=lstDealsHotModels.get(position).getHinhAnh();
        String ten=lstDealsHotModels.get(position).getTen();
        String mota=lstDealsHotModels.get(position).getMota();
        String gia=lstDealsHotModels.get(position).getGia();

        holder.setHinhAnh(resource);
        holder.setTen(ten);
        holder.setMoTa(mota);
        holder.setGia(gia);
    }

    @Override
    public int getItemCount() {
        return lstDealsHotModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewTenDealsHot;
        private TextView textViewMoTaDealsHot;
        private TextView textViewGiaDealsHot;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_Deals_Hot);
            textViewTenDealsHot = itemView.findViewById(R.id.textView_Ten_DealsHot);
            textViewMoTaDealsHot = itemView.findViewById(R.id.textView_MoTa_DealsHot);
            textViewGiaDealsHot = itemView.findViewById(R.id.textView_Gia_DealsHot);
        }

        private void setHinhAnh(int resource){
            imageView.setImageResource(resource);
        }
        private void setTen(String text){
            textViewTenDealsHot.setText(text);
        }
        private void setMoTa(String text){
            textViewMoTaDealsHot.setText(text);
        }
        private void setGia(String text){
            textViewGiaDealsHot.setText(text);
        }
    }
}
