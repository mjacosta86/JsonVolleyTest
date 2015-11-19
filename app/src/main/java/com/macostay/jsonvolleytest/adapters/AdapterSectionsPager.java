package com.macostay.jsonvolleytest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.macostay.jsonvolleytest.fragments.FragmentPlaceholder;
import com.macostay.jsonvolleytest.models.PersonList;
import com.macostay.jsonvolleytest.models.TeamList;

/**
 * Created by macostay on 22/10/2015.
 */
public class AdapterSectionsPager extends FragmentStatePagerAdapter {

    TeamList list;
//    PersonList list;

    /*public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }*/

    public AdapterSectionsPager(FragmentManager fm, TeamList t) {
        super(fm);
        this.list = t;
    }

//    public AdapterSectionsPager(FragmentManager fm, PersonList p) {
//        super(fm);
//        this.list = p;
//    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        return FragmentPlaceholder.newInstance(list.getList().get(position));
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        //return 3;
        return list.getList().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.getList().get(position).getName();
        /*switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;*/
    }
}

