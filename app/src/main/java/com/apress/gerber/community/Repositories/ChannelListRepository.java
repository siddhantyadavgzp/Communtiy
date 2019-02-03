package com.apress.gerber.community.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.apress.gerber.community.R;
import com.apress.gerber.community.UI.Fragments.SignUpFragment;
import com.apress.gerber.community.Utlity.ChannelsInRegion;
import com.apress.gerber.community.Utlity.PHPConstant;
import com.apress.gerber.community.Utlity.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelListRepository {
    public Context context;
    private MutableLiveData<List<ChannelsInRegion>> channels;

    public ChannelListRepository(Context context) {
        this.context = context;
    }
    public void setUserData(List<ChannelsInRegion> channelName){
        channels=new MutableLiveData<>();
        channels.setValue(channelName);
    }
    public LiveData<List<ChannelsInRegion>> getUserData(){
        return channels;
    }







}
