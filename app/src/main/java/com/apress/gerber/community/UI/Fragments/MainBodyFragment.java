package com.apress.gerber.community.UI.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apress.gerber.community.Interface.IOnBackPressed;
import com.apress.gerber.community.R;
import com.apress.gerber.community.UI.Fragments.InternalFragments.AccountDetails;
import com.apress.gerber.community.UI.Fragments.InternalFragments.Channels;
import com.apress.gerber.community.UI.Fragments.InternalFragments.Help;
import com.apress.gerber.community.UI.Fragments.InternalFragments.JoinChannels;

public class MainBodyFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener,IOnBackPressed {
    private DrawerLayout drawerLayout;
    private TextView textView;
    private Toolbar toolbar;
    private View viewContainer;
    private NavigationView navigationView;
    private JoinChannels join;
    private Help help;
    private AccountDetails acc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.a_main_body, container, false);
        drawerLayout = viewContainer.findViewById(R.id.drawer_layout_1);
        toolbar = viewContainer.findViewById(R.id.toolbar1);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = viewContainer.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, new Channels()).commit();
            navigationView.setCheckedItem(R.id.nav_channels);
        }

        return viewContainer;
    }



    @Override
    public boolean onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        if (getBoolean()) {
            navigationView.setCheckedItem(R.id.nav_channels);
            getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, new Channels()).commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_channels:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }
                getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, new Channels()).commit();
                break;
            case R.id.nav_join_channels:
                join = new JoinChannels();
                getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, join, "join").commit();
                break;
            case R.id.nav_account:
                acc = new AccountDetails();
                getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, acc, "account").commit();
                break;
            case R.id.nav_help:
                help = new Help();
                getFragmentManager().beginTransaction().replace(R.id.main_body_fragment, help, "help").commit();
                break;
            case R.id.nav_exit:

                getResponse();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getResponse() {

        AlertDialog.Builder signOutAlert = new AlertDialog.Builder(getActivity());
        signOutAlert.setMessage("Are you sure you want to sign out.").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               getFragmentManager().beginTransaction().replace(R.id.main_container, new LoginFragment()).commit();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert = signOutAlert.create();
        alert.setTitle("Sign Out");
        alert.show();
    }
    public boolean getBoolean() {
        boolean b;
        acc = (AccountDetails) getFragmentManager().findFragmentByTag("account");
        join = (JoinChannels) getFragmentManager().findFragmentByTag("join");
        help = (Help) getFragmentManager().findFragmentByTag("help");
        b = (acc != null && acc.isVisible()) || (join != null && join.isVisible()) || (help != null && help.isVisible());
        return b;
    }

}
