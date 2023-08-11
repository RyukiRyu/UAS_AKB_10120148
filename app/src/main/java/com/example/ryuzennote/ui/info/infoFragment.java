package com.example.ryuzennote.ui.info;
//10120148_Ariyandi Julian Pratama_IF4

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ryuzennote.R;
import com.example.ryuzennote.activity.mainActivity;
import com.example.ryuzennote.adapter.infoFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class infoFragment extends Fragment {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private mainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.view_pager_info);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (mainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();

        List<Fragment> list = new ArrayList<>();
        list.add(new infoFragment1());
        list.add(new infoFragment2());

        pagerAdapter = new infoFragmentAdapter(requireActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(pagerAdapter);
    }
}