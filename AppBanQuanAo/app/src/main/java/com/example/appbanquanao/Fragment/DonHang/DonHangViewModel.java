package com.example.appbanquanao.Fragment.DonHang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DonHangViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DonHangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}