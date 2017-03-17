package com.tenjirawat.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tenjirawat.mvcstructure.R;

/**
 * Created by ten30 on 3/16/2017.
 */

public class MainFragment extends Fragment{
    int sumVar;
    private TextView tvHello;

    public static MainFragment newInstance(int somVar){
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar",somVar);
        mainFragment.setArguments(args);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sumVar = getArguments().getInt("somVar");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        initInstance(rootView);

        return rootView;
    }

    private void initInstance(View rootView) {
        tvHello = (TextView) rootView.findViewById(R.id.tvHello);
    }
    public void setHelloText(String txt){
        tvHello.setText(txt);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            //restore here
        }
    }
}
