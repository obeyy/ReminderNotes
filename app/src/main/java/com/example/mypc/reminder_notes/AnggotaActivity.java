package com.example.mypc.reminder_notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mypc.reminder_notes.Fragment.BodyPartsFragment;
import com.example.mypc.reminder_notes.Fragment.ImageAssets;

public class AnggotaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);

        if (savedInstanceState == null) {

            BodyPartsFragment bodyFragment;
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            //membuat object untuk dita
            bodyFragment = new BodyPartsFragment();
            bodyFragment.setmImageIds(ImageAssets.getDita());
            bodyFragment.setmListIndex(0);
            //transaksi fragment body
            fragmentManager.beginTransaction().add(R.id.Dita_container, bodyFragment).commit();


            //membuat object untuk obby
            bodyFragment = new BodyPartsFragment();
            bodyFragment.setmImageIds(ImageAssets.getObby());
            bodyFragment.setmListIndex(0);
            //transaksi fragment body
            fragmentManager.beginTransaction().add(R.id.Obby_container, bodyFragment).commit();
        }
    }
}
