package com.example.alzakwani.memorysnap.user_home;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.alzakwani.memorysnap.Login;
import com.example.alzakwani.memorysnap.Photographer_Home;
import com.example.alzakwani.memorysnap.R;

import java.util.ArrayList;

public class User_Home extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    String[] Uname;
    TypedArray Uimage;
    RecyclerView recyclerr;
    ArrayList<User_Info> departmentInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);


        mDrawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        departmentInfoArrayList = new ArrayList<User_Info>();
        recyclerr =(RecyclerView)findViewById(R.id.recyclerView);
        Uname=getResources().getStringArray(R.array.parts_names);
        Uimage=getResources().obtainTypedArray(R.array.parts_imgs);
        createStudentList();
        RecyclerView.LayoutManager layoutManagerr = new LinearLayoutManager
                (this, LinearLayoutManager.VERTICAL,false);
        recyclerr.setLayoutManager(layoutManagerr);
        User_Adapter adapterr = new User_Adapter(this,departmentInfoArrayList);
        recyclerr.setAdapter(adapterr);
    }

    private void createStudentList() {

        for(int i=0;i<Uname.length;i++)
        {
            User_Info st = new User_Info();
            st.setName(Uname[i]);
            st.setImage(Uimage.getResourceId(i,-1));
            departmentInfoArrayList.add(st);



        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {

            return true;
        }
        return super.onOptionsItemSelected(item);

    }


}
