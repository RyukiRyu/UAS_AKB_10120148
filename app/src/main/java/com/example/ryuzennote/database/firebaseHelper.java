package com.example.ryuzennote.database;
//10120148_Ariyandi Julian Pratama_IF4

import android.database.Cursor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.ryuzennote.noteInterface;
import com.example.ryuzennote.model.note;

public class firebaseHelper implements noteInterface {

    private FirebaseAuth auth;
    private DatabaseReference databaseReference;

    public firebaseHelper() {
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notes").child(auth.getCurrentUser().getUid());
    }

    @Override
    public Cursor read(){
        return null;
    }

    @Override
    public boolean create(note note) {
        if (note.getId() != null) {
            databaseReference.child(note.getId()).setValue(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(note note) {
        if (note.getId() != null) {
            databaseReference.child(note.getId()).setValue(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (id != null) {
            databaseReference.child(id).removeValue();
            return true;
        }
        return false;
    }
}