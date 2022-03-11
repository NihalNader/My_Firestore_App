package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText ename,eaddress,ephone;
Button save,show;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
ename=findViewById(R.id.ename);
eaddress=findViewById(R.id.eaddress);
ephone=findViewById(R.id.ePhone);
save=findViewById(R.id.save);
show=findViewById(R.id.show);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        save.setOnClickListener( (v)->{
            Map<String,Object> user = new HashMap<>();
            user.put("name",ename.getText().toString());
            user.put("address",eaddress.getText().toString());
            user.put("phone",ephone.getText().toString());
            db.collection("user").add(user).addOnSuccessListener(documentReference ->
            {
                Log.d("tttt", "Add is done with id : "+documentReference.getId());
            }).addOnFailureListener(e -> {
                Log.d("tttt",e.getMessage());
            });
    });

        show.setOnClickListener((v)->{

            startActivity( new Intent(getApplicationContext(),MainActivity2.class));


        });





    }

}