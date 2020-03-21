package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.Volley;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditAccount extends Fragment {


    public EditAccount() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View rootview = inflater.inflate(R.layout.fragment_edit_account, container, false);

        return rootview;
    }

}
