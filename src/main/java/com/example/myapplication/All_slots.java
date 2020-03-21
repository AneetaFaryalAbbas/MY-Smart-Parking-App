package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class All_slots extends Fragment {
    Context context;
    ProgressDialog pd;
    String url= MainActivity .UrlAddress+"getColors.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    EditText txtBalance,txtTrx;
    ImageButton[] slot= new ImageButton[17];
//    ImageButton slot2;
//    ImageButton slot3;
//    ImageButton slot4;
//    ImageButton slot5;
//    ImageButton slot6;
//    ImageButton slot7;
//    ImageButton slot8;
//    ImageButton slot9;
//    ImageButton slot10;
//    ImageButton slot11;
//    ImageButton slot12;
//    ImageButton slot13;
//    ImageButton slot14;
//    ImageButton slot15;
//    ImageButton slot16;
//    ImageButton slot17;









    int[] images = {R.drawable.carparkingempty,R.drawable.carparkingfill};


    public All_slots() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_all_slots, container, false);




        queue= Volley.newRequestQueue(getContext());
        pd= new ProgressDialog(getContext());
        pd.setProgressStyle(pd.STYLE_SPINNER);
        pd.setTitle("Login __ !");
        pd.setMessage("Plz Wait ___  !");




        alertDialog= new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Message");





        slot[0]= (ImageButton) rootview.findViewById(R.id.sbtn1);
        slot[1]= (ImageButton) rootview.findViewById(R.id.sbtn2);
        slot[2]= (ImageButton) rootview.findViewById(R.id.sbtn3);
        slot[3]= (ImageButton) rootview.findViewById(R.id.sbtn4);
        slot[4]= (ImageButton) rootview.findViewById(R.id.sbtn5);
        slot[5]= (ImageButton) rootview.findViewById(R.id.sbtn6);
        slot[6]= (ImageButton) rootview.findViewById(R.id.sbtn7);
        slot[7]= (ImageButton) rootview.findViewById(R.id.sbtn8);
        slot[8]= (ImageButton) rootview.findViewById(R.id.sbtn9);
        slot[9]= (ImageButton) rootview.findViewById(R.id.sbtn10);
        slot[10]= (ImageButton) rootview.findViewById(R.id.sbtn11);
        slot[11]= (ImageButton) rootview.findViewById(R.id.sbtn12);
        slot[12]= (ImageButton) rootview.findViewById(R.id.sbtn13);
        slot[13]= (ImageButton) rootview.findViewById(R.id.sbtn14);
        slot[14]= (ImageButton) rootview.findViewById(R.id.sbtn15);
        slot[15]= (ImageButton) rootview.findViewById(R.id.sbtn16);
        slot[16]= (ImageButton) rootview.findViewById(R.id.sbtn17);



        slot[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity.smartPark_slono=1;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                .addToBackStack(null).commit();


            }
        });


        slot[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity.smartPark_slono=2;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag()).addToBackStack(null)
                        .commit();


            }
        });


        slot[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=3;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();




            }
        });


        slot[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=4;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });




        slot[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=5;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=6;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=7;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=8;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=9;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=10;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=11;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=12;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=13;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=14;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=15;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=16;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });

        slot[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.smartPark_slono=18;
                Book_slot ea= new Book_slot();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.contact_frame,ea,ea.getTag())
                        .commit();

                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });





        setColoring();

        return rootview;
    }





    public void setColoring(){


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
                    try {
                        JSONArray jsonarray = new JSONArray(response);
                        //  alertDialog.setMessage("Signing In ___  !");
                        // alertDialog.show();
                        for (int i = 0; i < jsonarray.length(); i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            String s1 = jsonobject.getString("id");
                            String s2 = jsonobject.getString("sts");
                            String name="";
                            if(s2.equals("0")){

                                slot[i].setEnabled(true);
                                slot[i].setImageResource(images[0]);
                            }

                            else if(s2.equals("1")){

                                slot[i].setEnabled(false);
                                slot[i].setImageResource(images[1]);
                            }
                            else
                            {
                                slot[i].setEnabled(false);
                                slot[i].setImageResource(images[1]);
                            }


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

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
