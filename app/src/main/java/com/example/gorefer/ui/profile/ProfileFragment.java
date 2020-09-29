package com.example.gorefer.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.gorefer.NotAsked;
import com.example.gorefer.R;
import com.example.gorefer.ui.Adapter.TabAdapter;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    Button btnIMF, button2;
    CircleImageView imageView;
    FloatingActionsMenu fab_menu;
    LinearLayout linear_lay;

    private ViewPager viewPager;
    private TabLayout tabLayout;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnIMF = view.findViewById(R.id.btnIMF);
        button2 = view.findViewById(R.id.button2);
        imageView = view.findViewById(R.id.imageView);
        fab_menu = view.findViewById(R.id.fab_menu);
        linear_lay = view.findViewById(R.id.linear_lay);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        btnIMF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String bdy = "This is an invitation to my app GoRefer!";
                String sub = "Hello my Friend";
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, bdy);
                startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NotAsked.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NotAsked.class);
                startActivity(intent);
            }
        });
        fab_menu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                linear_lay.setAlpha((float) 0.3);
            }

            @Override
            public void onMenuCollapsed() {
                linear_lay.setAlpha(1);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getChildFragmentManager());
        adapter.addFragment(new RequestsTab(), "Requests(100)");
        adapter.addFragment(new OfferingsTab(), "Offerings(0)");
        adapter.addFragment(new RecommendsTab(), "Recommends(0)");

        viewPager.setAdapter(adapter);
    }

}
