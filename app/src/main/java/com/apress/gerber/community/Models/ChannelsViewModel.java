package com.apress.gerber.community.Models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.apress.gerber.community.Repositories.ChannelListRepository;
import com.apress.gerber.community.Utlity.ChannelsInRegion;

import java.util.List;

public class ChannelsViewModel extends AndroidViewModel {

    ChannelListRepository channelListRepository;
    public ChannelsViewModel(@NonNull Application application) {
        super(application);
        channelListRepository=new ChannelListRepository(application);
    }
    public void setUserData(List<ChannelsInRegion> channleName){
        channelListRepository.setUserData(channleName);
    }

    public LiveData<List<ChannelsInRegion>> getUserData(){
      return channelListRepository.getUserData();
    }

}
