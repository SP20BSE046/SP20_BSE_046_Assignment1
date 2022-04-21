package com.example.programticfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    String message;
    private MutableLiveData <String> mutableLiveData;

    public void initialize (){
        mutableLiveData=new MutableLiveData<>();
    }
    public void setMessage (String message){
        //this.message= message;
        mutableLiveData.setValue(message);
    }
    public MutableLiveData<String> getMessage (){
        //return message;
        return mutableLiveData;
    }
}
