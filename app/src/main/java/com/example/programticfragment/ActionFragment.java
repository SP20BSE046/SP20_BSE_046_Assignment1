package com.example.programticfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ActionFragment extends Fragment {

    Button buttona;
    Button buttonb;
    TextView textView;
    leftFragCommInter leftFragComm;
    DataViewModel dataViewModel;
    public ActionFragment() {
        // Required empty public constructor
    }

    public static ActionFragment newInstance() {
        ActionFragment fragment = new ActionFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataViewModel= new ViewModelProvider((MainActivity) context).get(DataViewModel.class);
        try {
            leftFragComm=(MainActivity)context;
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_left, container, false);
        buttona=view.findViewById(R.id.Inputbtn);
        buttonb=view.findViewById(R.id.CalcBtn);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //leftFragComm.send("hello from fragment button a");
                dataViewModel.setMessage("hello from fragment");
            }
        });
    }

    public interface leftFragCommInter{
        void send (String message);
}
}