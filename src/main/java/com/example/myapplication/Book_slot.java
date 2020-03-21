package com.example.myapplication;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Book_slot extends Fragment {


    ProgressDialog pd;
    String url= MainActivity .UrlAddress+"BookSlot.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    Button btn;
    TextView txt1,txt2,txt3;
    EditText vechle_no,uname,Arival_time,Departure_time,Total_time,Total_fair,txtDate;
    EditText slotnum,uid,ubalance;
    String dateUsed;

    private int mYear, mMonth, mDay, mHour, mMinute,mHour2, mMinute2;

    private int h1,m1,h2,m2;

    public Book_slot() {
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

        //Typeface myfont= Typeface.createFromAsset(,"font/Trebuchet MS.ttf");

        View rootview = inflater.inflate(R.layout.fragment_book_slot, container, false);
        txtDate= (EditText) rootview.findViewById(R.id.book_date);
        btn= (Button) rootview.findViewById(R.id.btn_book);
        Arival_time = (EditText) rootview.findViewById(R.id.arrival_time);

        uname= (EditText) rootview.findViewById(R.id.book_username);
        slotnum= (EditText) rootview.findViewById(R.id.book_slot_number);
        ubalance= (EditText) rootview.findViewById(R.id.user_balance);
        vechle_no= (EditText) rootview.findViewById(R.id.book_veichle);
        slotnum.setText(MainActivity.smartPark_SlotNo);
        uname.setText(MainActivity.smartPark_username);
        ubalance.setText(MainActivity.smartPark_balance);

        slotnum.setText(""+MainActivity.smartPark_slono);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
//
                Toast.makeText(getContext(),"Date is :"+dateUsed,Toast.LENGTH_SHORT).show();

                String s1= MainActivity.smartPark_userid;
                String s2= vechle_no.getText().toString();
                String s3= slotnum.getText().toString();
                String s4= Arival_time.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("") ||s4.equals("") ){
                    Toast.makeText(getContext(),"Please Fill All the Field First",Toast.LENGTH_SHORT).show();
                }
                else {
                    add_data_toserver();
                }
            }
        });

        txtDate.setOnClickListener(new View.OnClickListener() {
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

                                txtDate.setText( dayOfMonth+ "-" + (monthOfYear + 1) + "-" + year);
                                dateUsed= ""+year+"-"+(monthOfYear+1)+"-"+dayOfMonth;

                            }
                        },mDay , mMonth, mYear);

                Toast.makeText(getContext(),"Date is :"+dateUsed,Toast.LENGTH_SHORT).show();
                datePickerDialog.show();
            }
        });


        Arival_time.setOnClickListener(new View.OnClickListener() {
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
                                Arival_time.setText(hourOfDay + ":" + minute);
                                h1=hourOfDay;
                                m1=minute;

                            }
                        }, mHour, mMinute, false);

                timePickerDialog.show();
            }
        });




//        Departure_time.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Get Current Time
//                final Calendar c1 = Calendar.getInstance();
//                mHour2 = c1.get(Calendar.HOUR_OF_DAY);
//                mMinute2 = c1.get(Calendar.MINUTE);
//                // Launch Time Picker Dialog
//                TimePickerDialog timePickerDialog1 = new TimePickerDialog(getContext(),
//                        new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//                                Departure_time.setText(hourOfDay + ":" + minute);
//                                h2=hourOfDay;
//                                m2=minute;
//                                show();
//                            }
//                        }, mHour2, mMinute2, false);
//                timePickerDialog1.show();
//
//
//            }
//        });

        return rootview;
    }

    //-------------------------------------------------------------------------------------------------------------------
     private void show(){

      int  h= h2 - h1;
      int  m= m2 - m1;
         Total_time.setText(h+":"+m);
         int time = (h*60) + m;
         double fair= time*0.5;

         Total_fair.setText(""+fair);
//      Toast.makeText(getContext(),"The Time is :"+h+" : "+m,Toast.LENGTH_SHORT).show();
     }
    //--------------------------------------------------------------------------------------------------------------------

    private void add_data_toserver(){

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
                params.put("s2",vechle_no.getText().toString());
                params.put("s3",slotnum.getText().toString());
                params.put("s4",dateUsed);
                params.put("s5",Arival_time.getText().toString());
                params.put("s6",uname.getText().toString());
                return params;
            }
        };
        queue.add(stringRequest);

        }

     //________________________________________________________________________________________________________________


    private void clear(){
        uname.setText("");
        vechle_no.setText("");
        txtDate.setText("");
    }


    //------------------------------------------------------------------------------------------------------------------


}
