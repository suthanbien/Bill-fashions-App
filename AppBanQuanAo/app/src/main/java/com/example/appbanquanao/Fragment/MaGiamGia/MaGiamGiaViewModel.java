package com.example.appbanquanao.Fragment.MaGiamGia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MaGiamGiaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MaGiamGiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}