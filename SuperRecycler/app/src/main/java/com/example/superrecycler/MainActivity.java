package com.example.superrecycler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    Adapteur adapter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        
        this.InitRecycler();
        RemplirRecycler();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void RemplirRecycler() {
        Long cpt = 0L;
        for (int i = 0; i < 1000; i++) {

            Secret s = new Secret();
            s.nom = "Bob";
            s.date = LocalDateTime.now();
            s.NbGrand = cpt++;

            adapter.list.add(s);

        }
        adapter.notifyDataSetChanged();





    }

    private void InitRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

         adapter = new Adapteur();
        recyclerView.setAdapter(adapter);




    }
}