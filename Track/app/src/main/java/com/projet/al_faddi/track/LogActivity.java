package com.projet.al_faddi.track;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by al-faddi on 28/09/2016.
 */
public class LogActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOGIN_URL = "http://192.168.17.50/id_admin/TrackMe/public/index.php/login";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonLogin;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_main);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(this);
    }
    private void userLogin() {
        email = editTextEmail.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        //jajoute mais c'est mis en bas

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    openProfile();
                }else{
                    Toast.makeText(LogActivity.this,response,Toast.LENGTH_LONG).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LogActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_EMAIL,email);
                map.put(KEY_PASSWORD,password);
                return map;
            }


        };
       
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(KEY_EMAIL, email);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        userLogin();
    }
}

