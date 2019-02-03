package com.apress.gerber.community.UI.Fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.apress.gerber.community.Models.ChannelsViewModel;
import com.apress.gerber.community.R;
import com.apress.gerber.community.Utlity.ChannelsInRegion;
import com.apress.gerber.community.Utlity.PHPConstant;
import com.apress.gerber.community.Utlity.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpFragment extends Fragment {
    private View viewContainer;
    private Button signUp;
    private EditText  email, password, mobile, confPassword,address;
    private ChannelsViewModel channelsViewModel;
    boolean process = false;
    List<ChannelsInRegion> channels;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.signup_fragment, container, false);
        email = viewContainer.findViewById(R.id.sign_up_email);
        channelsViewModel=ViewModelProviders.of(getActivity()).get(ChannelsViewModel.class);
        password = viewContainer.findViewById(R.id.sign_up_password);
        address=viewContainer.findViewById(R.id.Address);
        confPassword = viewContainer.findViewById(R.id.sign_up_conf_password);
        mobile = viewContainer.findViewById(R.id.sign_up_mobile);
        signUp = viewContainer.findViewById(R.id.sign_up_submit_button);
        channels=new ArrayList<>();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMethod();
            }
        });
        return viewContainer;
    }

    public void newMethod() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                PHPConstant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonObject = new JSONArray(response);


                                for (int i = 0; i <jsonObject.length();i++)
                                {


                                    channels.add(new ChannelsInRegion(jsonObject.getString(i)));

                                }
                                channelsViewModel.setUserData(channels);
                            Toast.makeText(getActivity(), "signUp Successful", Toast.LENGTH_SHORT).show();
                         }catch (JSONException e) {
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
                params.put("name",email.getText().toString());
                params.put("password", password.getText().toString());
                params.put("city",address.getText().toString() );
                params.put("mobile",mobile.getText().toString());
                params.put("m", "1");
                return params;
            }
        };
        RequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }


}
