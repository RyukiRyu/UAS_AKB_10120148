package com.example.ryuzennote;
//10120148_Ariyandi Julian Pratama_IF4

import android.database.Cursor;

import com.example.ryuzennote.model.note;

public interface noteInterface {
    public Cursor read();
    public boolean create(note note);
    public boolean update(note note);
    public boolean delete(String id);

}