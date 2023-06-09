package com.mirea.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsView extends AppCompatActivity {

    RecylerViewAdapter recylerViewAdapter;
    RecyclerView recyclerView;
    ArrayList<UserData> userDataArrayList = new ArrayList<>();
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts__view);
        db = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyler_view);

        recylerViewAdapter = new RecylerViewAdapter(this,userDataArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recylerViewAdapter);

        loadContactList();
    }
    public void loadContactList(){
        userDataArrayList.clear();

        List<UserData> userDataList = db.getAllContacts();

        userDataArrayList.addAll(userDataList);
        recylerViewAdapter.notifyDataSetChanged();

    }




}
