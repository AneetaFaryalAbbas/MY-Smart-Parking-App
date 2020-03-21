package com.example.myapplication;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
public class UpdateAccount extends Fragment {


    ProgressDialog pd;
    String url=MainActivity.UrlAddress+"UpdateAccount.php";
    StringRequest stringRequest;
    RequestQueue queue;
    AlertDialog alertDialog;
    private int mYear, mMonth, mDay, mHour, mMinute,mHour2, mMinute2;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button btn;
    public UpdateAccount() {
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
        View rootview = inflater.inflate(R.layout.fragment_update_account, container, false);


        t1= (EditText) rootview.findViewById(R.id.up_Ac_AccountNo);
        t2= (EditText) rootview.findViewById(R.id.up_Ac_username);
        t3= (EditText) rootview.findViewById(R.id.up_Ac_password);
        t4= (EditText) rootview.findViewById(R.id.up_Ac_CnicNo);
        t5= (EditText) rootview.findViewById(R.id.up_Ac_license);
        t6= (EditText) rootview.findViewById(R.id.up_Ac_contactNo);
        t7= (EditText) rootview.findViewById(R.id.up_Ac_address);
        btn= (Button) rootview.findViewById(R.id.btn_update_account);



        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Launching new Activity on selecting single List Item

                String s1 = t1.getText().toString();
                String s2 = t2.getText().toString();
                String s3 = t3.getText().toString();
                String s4 = t4.getText().toString();
                String s5 = t5.getText().toString();
                String s6 = t6.getText().toString();
                String s7 = t7.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("")) {

                    Toast.makeText(getContext(), "Please Fill All the Fields First ", Toast.LENGTH_SHORT).show();
                } else {
                    send_to_server();
                }
            }
        });


     setData();
        return rootview;
    }


    private void setData() {

    t1.setText(MainActivity.smartPark_userid);
    t2.setText(MainActivity.smartPark_username);
    t3.setText(MainActivity.smartPark_password);
    t4.setText(MainActivity.smartPark_cnicNo);
    t5.setText(MainActivity.smartPark_license);
    t6.setText(MainActivity.smartPark_contactNo);
    t7.setText(MainActivity.smartPark_address);

    }


    //----------------------------------------------------------------------------------------------------------

  private void send_to_server() {
        pd.show();
      stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

          @Override
          public void onResponse(String response) {
              pd.dismiss();
              pd.dismiss();
              if(response==null){
                  alertDialog.setMessage("No Response From the server __  !");
                  alertDialog.show();
              }
              else {

                  clear();
                  alertDialog.setMessage("Has Been Craeted"+response);
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

              params.put("s1",t1.getText().toString());
              params.put("s2",t2.getText().toString());
              params.put("s3",t3.getText().toString());
              params.put("s4",t4.getText().toString());
              params.put("s5",t5.getText().toString());
              params.put("s6",t6.getText().toString());
              params.put("s7",t7.getText().toString());



              return params;
          }
      };
      queue.add(stringRequest);

  }

//=----------------------------------------------------------------------------------------------------
    private void clear(){

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");

    }
}
