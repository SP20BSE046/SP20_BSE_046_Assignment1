package com.example.programticfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActionFragment.leftFragCommInter{
private FragmentManager fragmentManager;
private ActionFragment actionFragment;
private MessageFragment messageFragment;
DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation=getResources().getConfiguration().orientation;
        dataViewModel= new ViewModelProvider(this).get(DataViewModel.class);
        dataViewModel.initialize();

        if (orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
        fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        actionFragment = ActionFragment.newInstance();
        messageFragment = MessageFragment.newInstance();
        fragmentTransaction.replace(R.id.LeftFL, actionFragment);
        fragmentTransaction.replace(R.id.RighFL, messageFragment);
        fragmentTransaction.commit();}
    }

    @Override
    public void send(String message) {
        messageFragment.getMessage(message);
    }
}