package com.example.appbanquanao.Fragment.TrangChu;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbanquanao.Adapter.DealsHotAdapter;
import com.example.appbanquanao.Adapter.LoaiSanPhamAdapter;
import com.example.appbanquanao.Adapter.SliderAdapter;
import com.example.appbanquanao.Model.DealsHotModel;
import com.example.appbanquanao.Model.LoaiSanPhamModel;
import com.example.appbanquanao.Model.SliderModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class TrangChuFragment extends Fragment {

    //loại SP
    private TrangChuViewModel homeViewModel;
    private RecyclerView loaiSP_RecyclerView;
    private LoaiSanPhamAdapter loaiSP_Adapter;

    //phần banner
    private ViewPager2 bannerSliderViewPage;
    private List<SliderModel> lstSliderModel;
    private Handler slideHandler=new Handler();

    //phần adBanner
    private ConstraintLayout stripAdContainer;
    private ImageView imageViewStripAd;

    //phần Deals Hot
    private RecyclerView recyclerViewScrollLayout;
    private Button buttonXemThem;
    private TextView textViewDealsHot;




    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(TrangChuViewModel.class);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        //phần loại SP
        loaiSP_RecyclerView=view.findViewById(R.id.recyclerView_LoaiSP);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        loaiSP_RecyclerView.setLayoutManager(layoutManager);

        List<LoaiSanPhamModel> lstLoaiSP=new ArrayList<LoaiSanPhamModel>();
        lstLoaiSP.add(new LoaiSanPhamModel("link","123123"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","234234"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","345345"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","456456"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","567567"));


        loaiSP_Adapter=new LoaiSanPhamAdapter(lstLoaiSP);
        loaiSP_RecyclerView.setAdapter(loaiSP_Adapter);
        loaiSP_Adapter.notifyDataSetChanged();

        //phần panner
        bannerSliderViewPage = view.findViewById(R.id.banner_slider_ViewPage);

        lstSliderModel=new ArrayList<SliderModel>();
        lstSliderModel.add(new SliderModel(R.mipmap.banner1));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner5));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner1));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner5));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));


        bannerSliderViewPage.setAdapter(new SliderAdapter(lstSliderModel,bannerSliderViewPage));

        bannerSliderViewPage.setClipToPadding(false);
        bannerSliderViewPage.setClipChildren(false);

        bannerSliderViewPage.setOffscreenPageLimit(3);
        bannerSliderViewPage.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);


        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        bannerSliderViewPage.setPageTransformer(compositePageTransformer);
        bannerSliderViewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,3000);
            }
        });

        //phần adBanner
        stripAdContainer = view.findViewById(R.id.strip_ad_container);
        imageViewStripAd = view.findViewById(R.id.imageView_strip_ad);
        imageViewStripAd.setImageResource(R.mipmap.adbanner1);
        stripAdContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        //phần Deals Hot
        recyclerViewScrollLayout = view.findViewById(R.id.recyclerView_scroll_layout);
        buttonXemThem = view.findViewById(R.id.button_XemThem);
        textViewDealsHot = view.findViewById(R.id.textView_deals_hot);

        List<DealsHotModel> lstDealsHotModel=new ArrayList<DealsHotModel>();
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao1,"Quần của Tí","Quần có 1 không 2","Chỉ từ: 200.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao2,"Quần của Tèo","26% kháng mọi sát thương","Chỉ từ: 300.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao3,"Quần của Tũn","Tỉ lệ 200% té SML","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao1,"Quần của Abe","Quần có 1 không 2","Chỉ từ: 100.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao3,"Set đồ hot","95% Tỉ lệ ăn hành","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao2,"Set Umbala","1000% Kháng Phép","Chỉ từ: 1.600.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao2,"Quần của Huck","Chất liệu bềnh nhất vũ trụ","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new DealsHotModel(R.mipmap.quanao1,"Quần què","Thiết kế độc lạ","Chỉ từ: 800.000 VNĐ"));


        DealsHotAdapter dealsHotAdapter=new DealsHotAdapter(lstDealsHotModel);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewScrollLayout.setLayoutManager(linearLayoutManager);
        recyclerViewScrollLayout.setAdapter(dealsHotAdapter);
        dealsHotAdapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunnable,3000);
    }

    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            bannerSliderViewPage.setCurrentItem(bannerSliderViewPage.getCurrentItem()+1);
        }
    };

}