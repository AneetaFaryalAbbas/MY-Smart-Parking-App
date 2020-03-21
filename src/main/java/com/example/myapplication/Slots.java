package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Slots extends Fragment {

    ListView list;
    ProgressDialog pd;
    String url=MainActivity.UrlAddress+"free_slot.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    TextView t1;

    ArrayList<DataModel_Slots> dataModels;
    private static DataAdapter_EmptySlot adapter;

    public Slots() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        queue= Volley.newRequestQueue(getContext());
        pd= new ProgressDialog(getContext());
        pd.setProgressStyle(pd.STYLE_SPINNER);
        pd.setTitle("Login __ !");
        pd.setMessage("Plz Wait ___  !");
        alertDialog= new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Message");
        // Inflate the layout for this fragment
         View rootview = inflater.inflate(R.layout.fragment_slots, container, false);
        list= (ListView) rootview.findViewById(R.id.listeslots);
        t1= (TextView) rootview.findViewById(R.id.display);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
              //  Log.v("TAG", "CLICKED row number: " + arg2);
                String s= dataModels.get(arg2).getId();

                MainActivity.smartPark_SlotNo=s;


                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

            }

        });


        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

              Toast.makeText(getContext(),"pakistan",Toast.LENGTH_SHORT).show();

                UpdateAccount ea= new UpdateAccount();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();
            }
        });




        showlist();
        return rootview;
    }




    private void showlist(){

        dataModels= new ArrayList<>();
        dataModels.clear();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response==null){
                    alertDialog.setMessage("No Response From the server __  !");
                    alertDialog.show();
                }
                else {
                    try {
                        JSONArray jsonarray = new JSONArray(response);
                     //   alertDialog.setMessage("The Size of the Object :" + jsonarray.length());
                      //  alertDialog.show();
                        for (int i = 0; i < jsonarray.length(); i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            String s1 = jsonobject.getString("id");
                            String s2 = jsonobject.getString("title");
                            String s3 = jsonobject.getString("sts");
                            dataModels.add(new DataModel_Slots(s1,s2,s3));

                        }
                        adapter= new DataAdapter_EmptySlot(dataModels,getContext());
                        list.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                     //   alertDialog.setMessage("Excption :" + e.toString());
                     //   alertDialog.show();
                    }
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
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
