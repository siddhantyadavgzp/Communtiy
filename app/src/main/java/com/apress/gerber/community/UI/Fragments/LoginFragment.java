package com.apress.gerber.community.UI.Fragments;

import
        android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.apress.gerber.community.R;
import com.apress.gerber.community.Utlity.PHPConstant;
import com.apress.gerber.community.Utlity.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {
    private View viewContainer;
    private EditText email, password;
    private TextView signup;
    private Button login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.login_fragment, container, false);
        email = viewContainer.findViewById(R.id.login_email);
        password = viewContainer.findViewById(R.id.login_password);
        login = viewContainer.findViewById(R.id.login_button);
        signup = viewContainer.findViewById(R.id.login_sign_up_button);
        onClickEvents();
        return viewContainer;

    }


    public void onClickEvents() {

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.main_container, new SignUpFragment()).addToBackStack(null).commit();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getFragmentManager().beginTransaction().replace(R.id.main_container,new MainBodyFragment(),"crazy_stuff").commit();
            }
        });
    }




    public void newMethod(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                PHPConstant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getActivity(), jsonObject.getString("m"), Toast.LENGTH_LONG).show();
                            if (jsonObject.getString("the fucking code that is requi").equals("Yes"))
                            {

                                getFragmentManager().beginTransaction().replace(R.id.main_container, new SignUpFragment()).addToBackStack(null).commit();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name","the fucking name");
                params.put("password","roorkee_anime");
                params.put("m","1");
                return params;
            }
        };
        RequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }



}
