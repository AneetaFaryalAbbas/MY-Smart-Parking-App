package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceTransaction extends Fragment {

    ProgressDialog pd;
    String url= MainActivity .UrlAddress+"setTrasactions.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    EditText txtBalance,txtTrx;



    public BalanceTransaction() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        queue= Volley.newRequestQueue(getContext());
        pd= new ProgressDialog(getContext());
        pd.setProgressStyle(pd.STYLE_SPINNER);
        pd.setTitle("Login __ !");
        pd.setMessage("Plz Wait ___  !");
        alertDialog= new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Message");

        View rootview = inflater.inflate(R.layout.fragment_balance_transaction, container, false);

        txtBalance= (EditText) rootview.findViewById(R.id.UpdateAccount_balance);
        btn= (Button) rootview.findViewById(R.id.UpdateAccount_btn);
        txtTrx = (EditText) rootview.findViewById(R.id.UpdateAccount_TrxId);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String s1= MainActivity.smartPark_userid;
                String s2= txtBalance.getText().toString();
                String s3= txtTrx.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")  ){
                    Toast.makeText(getContext(),"Please Fill All the Field First",Toast.LENGTH_SHORT).show();
                }
                else {
                    UpdateAmount();
                }
            }
        });

        return rootview;
    }

    //--------------------------------------------------------------------------------------------------------


    private void UpdateAmount(){
        pd.show();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                pd.dismiss();
                pd.cancel();
                if(response==null){
                    alertDialog.setMessage("No Response From the server __  !");
                    alertDialog.show();
                }
                else {

                    clear();
                    alertDialog.setMessage("Has Been Craeted Successfully __  !");
                    alertDialog.show();


                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError){
                pd.dismiss();
                pd.cancel();
                String message = null;
                if (volleyError instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (volleyError instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (volleyError instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                alertDialog.setMessage("" + message);
                alertDialog.show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("s1",MainActivity.smartPark_userid.toString());
                params.put("s2",txtBalance.getText().toString());
                params.put("s3",txtTrx.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);

    }

    //________________________________________________________________________________________________________________


    private void clear(){
        txtTrx.setText("");
        txtBalance.setText("");

    }



}
