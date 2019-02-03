package com.apress.gerber.community.UI.Fragments.InternalFragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apress.gerber.community.R;
import com.apress.gerber.community.UI.Adapter.JoinChannelAdapter;
import com.apress.gerber.community.Utlity.ChannelsInRegion;
import com.apress.gerber.community.Utlity.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class JoinChannels extends Fragment {
    private View viewContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.i_join_channels, container, false);
        runRecycler();


        return viewContainer;
    }

    public void runRecycler() {

        RecyclerView recyclerView = viewContainer.findViewById(R.id.join_channels_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        final JoinChannelAdapter adapter = new JoinChannelAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        List<ChannelsInRegion> channelNames = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            channelNames.add(new ChannelsInRegion("channel name " + i));
        adapter.setCommunityDetails(channelNames,true);
    }


}
