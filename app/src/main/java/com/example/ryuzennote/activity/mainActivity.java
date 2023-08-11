package com.example.ryuzennote.activity;
//10120148_Ariyandi Julian Pratama_IF4
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.ryuzennote.R;
import com.example.ryuzennote.ui.info.infoFragment;
import com.example.ryuzennote.ui.note.noteFragment;
import com.example.ryuzennote.ui.profile.profileFragment;
import com.google.firebase.auth.FirebaseAuth;

public class mainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getFragmentPage(new infoFragment());

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.info){
                    fragment = new infoFragment();
                } else if (itemId == R.id.notes) {
                    fragment = new noteFragment();
                } else if (itemId == R.id.profile ) {
                    fragment = new profileFragment();
                } else if (itemId == R.id.logout) {
                    performLogout();
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private void performLogout() {
        auth.signOut();
        // Hapus data login dari SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        // Arahkan pengguna ke halaman login
        Intent intent = new Intent(mainActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}