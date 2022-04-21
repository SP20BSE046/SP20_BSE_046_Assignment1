package com.example.programticfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MessageFragment extends Fragment {

    TextView textView;
    DataViewModel dataViewModel;
    Button button;
    public MessageFragment() {
        // Required empty public constructor
    }


    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataViewModel= new ViewModelProvider((MainActivity) context).get(DataViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        MutableLiveData <String> mutableLiveData= dataViewModel.getMessage();
        mutableLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText(dataViewModel.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_right, container, false);
        textView=view.findViewById(R.id.NumT1);
        return view;
    }
    public void getMessage (String message){
        textView.setText(message);
    }
}