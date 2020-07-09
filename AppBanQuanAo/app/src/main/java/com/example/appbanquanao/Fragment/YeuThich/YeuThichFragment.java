package com.example.appbanquanao.Fragment.YeuThich;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appbanquanao.R;

public class YeuThichFragment extends Fragment {

    private YeuThichViewModel mViewModel;

    public static YeuThichFragment newInstance() {
        return new YeuThichFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yeu_thich_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(YeuThichViewModel.class);
        // TODO: Use the ViewModel
    }

}