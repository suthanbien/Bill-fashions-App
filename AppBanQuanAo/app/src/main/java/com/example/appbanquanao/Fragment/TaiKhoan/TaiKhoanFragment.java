package com.example.appbanquanao.Fragment.TaiKhoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.appbanquanao.R;

public class TaiKhoanFragment extends Fragment {

    private TaiKhoanViewModel mViewModel;

    public static TaiKhoanFragment newInstance() {
        return new TaiKhoanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tai_khoan_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TaiKhoanViewModel.class);
        // TODO: Use the ViewModel
    }

}