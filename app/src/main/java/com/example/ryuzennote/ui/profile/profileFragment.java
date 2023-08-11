package com.example.ryuzennote.ui.profile;
//10120148_Ariyandi Julian Pratama_IF4

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.example.ryuzennote.R;
import com.example.ryuzennote.activity.loginActivity;

public class profileFragment extends Fragment {

    private Button btnLogout;
    private FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        auth = FirebaseAuth.getInstance();

        btnLogout = view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
        return view;
    }

    private void logout() {
        auth.signOut();
        if (auth.getCurrentUser() == null) {
            Intent intent = new Intent(getActivity(), loginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
            Toast.makeText(getActivity(), "Logout Succeed", Toast.LENGTH_SHORT).show();
        }
    }
}