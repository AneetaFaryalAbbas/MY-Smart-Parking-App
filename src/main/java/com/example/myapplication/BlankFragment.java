package com.example.myapplication;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ProgressDialog pd;
    String url=MainActivity.UrlAddress+"find_slot.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    TextView txt1,txt2,txt3;
    EditText bdate,arTime,DepTime;



    private int mYear, mMonth, mDay, mHour, mMinute,mHour2, mMinute2;

    private int h1,m1,h2,m2;

    public BlankFragment() {
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

        //Typeface myfont= Typeface.createFromAsset(,"font/Trebuchet MS.ttf");

        View rootview = inflater.inflate(R.layout.fragment_blank, container, false);


        bdate= (EditText) rootview.findViewById(R.id.find_date1);
        btn= (Button) rootview.findViewById(R.id.find_btn);
        arTime = (EditText) rootview.findViewById(R.id.find_timeAr);
        DepTime = (EditText) rootview.findViewById(R.id.find_timeDept);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                    Slots f= new Slots();
                    Bundle b = new Bundle();
                    b.putString("msg", "pak");
                    f.setArguments(b);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.contact_frame,f,f.getTag())
                            .commit();
            }

        });

        bdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                bdate.setText( year+ "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        arTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                arTime.setText(hourOfDay + ":" + minute);
                                h1=hourOfDay;
                                m1=minute;

                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });




        DepTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Get Current Time
                final Calendar c1 = Calendar.getInstance();
                mHour2 = c1.get(Calendar.HOUR_OF_DAY);
                mMinute2 = c1.get(Calendar.MINUTE);
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog1 = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                DepTime.setText(hourOfDay + ":" + minute);
                                h2=hourOfDay;
                                m2=minute;
                            }
                        }, mHour2, mMinute2, false);
                timePickerDialog1.show();


            }
        });


        return  rootview;
    }



    private void get_slots(){

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
                            String s2 = jsonobject.getString("username");
                            String s3 = jsonobject.getString("password");
                            String s4 = jsonobject.getString("cnic");
                            String s5 = jsonobject.getString("license");
                            String s6 = jsonobject.getString("contact");
                            String s7 = jsonobject.getString("address");
                            String s8 = jsonobject.getString("balance");
                            String s9 = jsonobject.getString("joindate");

                            MainActivity.smartPark_userid=s1;
                            MainActivity.smartPark_username=s2;
                            MainActivity.smartPark_password=s3;
                            MainActivity.smartPark_cnicNo=s4;
                            MainActivity.smartPark_license=s5;
                            MainActivity.smartPark_contactNo=s6;
                            MainActivity.smartPark_address=s7;
                            MainActivity.smartPark_balance= s8;
                            MainActivity.smartPark_joinDate=s9;

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        alertDialog.setMessage("Excption :" + e.toString());
                        alertDialog.show();
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
                params.put("s1", bdate.getText().toString());
                params.put("s2", arTime.getText().toString());
                params.put("s3", DepTime.getText().toString());
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
