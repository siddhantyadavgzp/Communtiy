package com.apress.gerber.community.UI.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apress.gerber.community.R;
import com.apress.gerber.community.UI.Fragments.InternalFragments.Channels;
import com.apress.gerber.community.Utlity.ChannelsInRegion;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class JoinChannelAdapter extends RecyclerView.Adapter<JoinChannelAdapter.JoinChannelCardHolder> {
    private List<ChannelsInRegion> communityDetails = new ArrayList<>();
    private Boolean val;
    @NonNull
    @Override
    public JoinChannelCardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_join_channels, viewGroup, false);
        return new JoinChannelCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JoinChannelCardHolder joinChannelCardHolder, int i) {
        final ChannelsInRegion currentData = communityDetails.get(i);
        if (val==false)
            joinChannelCardHolder.image.setVisibility(View.INVISIBLE);
        joinChannelCardHolder.name.setText(currentData.getChannels());
    }

    @Override
    public int getItemCount() {
        return communityDetails.size();
    }

    public void setCommunityDetails(List<ChannelsInRegion> historyData,boolean val) {
        this.val=val;
        this.communityDetails = historyData;
        notifyDataSetChanged();
    }

    class JoinChannelCardHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;
        public JoinChannelCardHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.plus);
            name = itemView.findViewById(R.id.text_view_title);
        }
    }
}
