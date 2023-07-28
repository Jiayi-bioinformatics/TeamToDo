package com.example.teamtodo.group;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teamtodo.RecentList;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecentList();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }


}
