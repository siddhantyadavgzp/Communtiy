package com.apress.gerber.community.UI.Fragments;

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

import com.apress.gerber.community.R;
import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {
    private View viewContainer;
    private Button signUp;
    private EditText name, email, password, mobile, confPassword;
    boolean process = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.signup_fragment, container, false);
        email = viewContainer.findViewById(R.id.sign_up_email);
        password = viewContainer.findViewById(R.id.sign_up_password);
        confPassword = viewContainer.findViewById(R.id.sign_up_conf_password);
        mobile = viewContainer.findViewById(R.id.sign_up_mobile);
        signUp = viewContainer.findViewById(R.id.sign_up_submit_button);

        return viewContainer;
    }




}
