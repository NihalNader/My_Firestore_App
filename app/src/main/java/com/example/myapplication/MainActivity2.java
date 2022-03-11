package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
     ArrayList<Users>usersArrayList;
     RecyclerView recycleview;
    recycleAdapter recycleAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


       progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();
        recycleview=findViewById(R.id.recyclerView);
        recycleview.setHasFixedSize(true);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        usersArrayList =new ArrayList<>();
        recycleAdapter=new recycleAdapter(MainActivity2.this,usersArrayList);

        recycleview.setAdapter(recycleAdapter);

        db=FirebaseFirestore.getInstance();

        
        EventChangeListener();





//        setUserInfo();
//        setAdapter();
//        db.collection("products").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful()){
//                            task.getResult();
//                            QuerySnapshot result=task.getResult();
//                            for(QueryDocumentSnapshot document:result){
//                                String id=document.getId();
//                                Map<String,Object> data=document.getData();
//                                Log.e("kerroo", String.valueOf(data));
//                            }
//                        }
//                    }
//
//                });
    }

    private void EventChangeListener() {
        db.collection("user").orderBy("name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
            if(error != null){
                if(progressDialog.isShowing())
                    progressDialog.dismiss();
    Log.e("error",error.getMessage());
    return;

            }

            for(DocumentChange dc:value.getDocumentChanges()){
                if(dc.getType() == DocumentChange.Type.ADDED){
usersArrayList.add(dc.getDocument().toObject(Users.class));


                }
recycleAdapter.notifyDataSetChanged();
                if(progressDialog.isShowing())
                    progressDialog.dismiss();

            }



                    }
                });
    }

//    private void setAdapter() {
//        recycleAdapter adapter=new recycleAdapter(productlist);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
//        recycleview.setLayoutManager(layoutManager);
//        recycleview.setItemAnimator(new DefaultItemAnimator());
//        recycleview.setAdapter(adapter);
//    }
//
//    private void setUserInfo() {
//        productlist.add(new Users("hjj"));
//        productlist.add(new Users("llllll"));
//        productlist.add(new Users("ppppp"));
//
//    }
}