package ru.arcadudu.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.myapplication.frags.Frag1;
import ru.arcadudu.myapplication.frags.Frag11;
import ru.arcadudu.myapplication.frags.Frag2;

public class MainActivity extends AppCompatActivity{

    ViewPager pager;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tablayout);

        list.add(new Frag11());
        list.add(new Frag2());

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);


    }


}