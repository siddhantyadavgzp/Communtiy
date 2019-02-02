package com.apress.gerber.community.UI.Fragments.InternalFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apress.gerber.community.R;

public class Channels extends Fragment {
    private View viewContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer=inflater.inflate(R.layout.i_channels,container,false);
        return viewContainer;
    }
}
