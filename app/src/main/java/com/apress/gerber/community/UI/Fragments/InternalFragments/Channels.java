package com.apress.gerber.community.UI.Fragments.InternalFragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apress.gerber.community.Models.ChannelsViewModel;
import com.apress.gerber.community.R;
import com.apress.gerber.community.UI.Adapter.JoinChannelAdapter;
import com.apress.gerber.community.Utlity.ChannelsInRegion;
import com.apress.gerber.community.Utlity.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class Channels extends Fragment {
    private View viewContainer;
    private ChannelsViewModel channelsViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer=inflater.inflate(R.layout.i_channels,container,false);
        channelsViewModel=ViewModelProviders.of(getActivity()).get(ChannelsViewModel.class);
        runRecycler();

        return viewContainer;
    }
    public void runRecycler() {

        RecyclerView recyclerView = viewContainer.findViewById(R.id.channels_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        final JoinChannelAdapter adapter = new JoinChannelAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                getFragmentManager().beginTransaction().replace(R.id.main_body_fragment,new Chat()).addToBackStack(null).commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        channelsViewModel.getUserData().observe(getActivity(), new Observer<List<ChannelsInRegion>>() {
            @Override
            public void onChanged(@Nullable List<ChannelsInRegion> channelsInRegions) {
                adapter.setCommunityDetails(channelsInRegions,false);
            }
        });

    }

}
