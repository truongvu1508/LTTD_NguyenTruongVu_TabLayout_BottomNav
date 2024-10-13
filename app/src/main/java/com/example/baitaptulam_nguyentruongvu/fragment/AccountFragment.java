package com.example.baitaptulam_nguyentruongvu.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.baitaptulam_nguyentruongvu.account.ClassFragment;
import com.example.baitaptulam_nguyentruongvu.account.NameFragment;
import com.example.baitaptulam_nguyentruongvu.account.StudentCodeFragment;
import com.google.android.material.tabs.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.baitaptulam_nguyentruongvu.R;

public class AccountFragment extends Fragment {

    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tab_layout);
        frameLayout = view.findViewById(R.id.account_frame_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Name"));
        tabLayout.addTab(tabLayout.newTab().setText("StudentCode"));
        tabLayout.addTab(tabLayout.newTab().setText("Class"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment selectedFragment = null;

                switch (tab.getPosition()) {
                    case 0:
                        selectedFragment = new NameFragment();
                        break;
                    case 1:
                        selectedFragment = new StudentCodeFragment();
                        break;
                    case 2:
                        selectedFragment = new ClassFragment();
                        break;
                }

                if (selectedFragment != null) {
                    replaceFragment(selectedFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        replaceFragment(new NameFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.account_frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
