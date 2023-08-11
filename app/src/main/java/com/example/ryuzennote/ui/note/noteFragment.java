package com.example.ryuzennote.ui.note;
//10120148_Ariyandi Julian Pratama_IF4

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ryuzennote.model.note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.ryuzennote.R;
import com.example.ryuzennote.activity.addNoteActivity;
import com.example.ryuzennote.activity.mainActivity;
import com.example.ryuzennote.adapter.noteAdapter;

import java.util.ArrayList;
import java.util.List;

public class noteFragment extends Fragment  {
    private mainActivity mainActivity;
    private List<note> notes;
    private DatabaseReference notesRef;
    private RecyclerView recyclerView;
    private noteAdapter noteAdapter;
    private FloatingActionButton addButton;;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (mainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.myNote);
        addButton = view.findViewById(R.id.btnAddNote);
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), addNoteActivity.class));
        });
        notesRef = FirebaseDatabase.getInstance().getReference().child("Notes").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        read();
    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }

    private void read() {
        notes = new ArrayList<note>();
        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                notes.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    note note = snapshot.getValue(note.class);
                    notes.add(note);
                }
                noteAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        noteAdapter = new noteAdapter(notes);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}