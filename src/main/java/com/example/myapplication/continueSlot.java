package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class continueSlot extends Fragment {

    ListView list;
    ProgressDialog pd;
    String url=MainActivity.UrlAddress+"continue_slots.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    TextView tdisplay;

    ArrayList<Slot_DataModel> dataModels;
    private static SlotDataAdapter adapter;

    public continueSlot() {
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




        View rootview = inflater.inflate(R.layout.fragment_continue_slot, container, false);
        list= (ListView) rootview.findViewById(R.id.listcontinueslot);


        findBooking();
        return rootview;
    }


    private void findBooking(){


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
                        alertDialog.setMessage("The Size of the Object :" + jsonarray.length());
                        alertDialog.show();
                        for (int i = 0; i < jsonarray.length()-1; i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            String s1 = jsonobject.getString("id");
                            String s2 = jsonobject.getString("date");
                            String s3 = jsonobject.getString("arrival_time");
                            String s4 = jsonobject.getString("departure_time");
                            String s5 = jsonobject.getString("veichleReg");
                            String s6 = jsonobject.getString("username");
                            String s7 = jsonobject.getString("sts");
                             s7="Continue";
                            s4="--------";
                            dataModels.add(new Slot_DataModel(s1,s2,s3,s4,s5,s6,s7));
                        }
                        adapter= new SlotDataAdapter(dataModels,getContext());
                        list.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        alertDialog.setMessage("Excption :" + e.toString());
                        alertDialog.show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                alertDialog.setMessage("No Response /n" + "Error" + error.toString());
                alertDialog.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("s1", MainActivity.smartPark_userid);
                return params;
            }
        };
        queue.add(stringRequest);

    }


}
