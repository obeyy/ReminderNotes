package com.example.mypc.reminder_notes.Fragment;


import com.example.mypc.reminder_notes.R;

import java.util.ArrayList;
import java.util.List;

//buat cetakan tubuh
public class ImageAssets {

    //membuat list array untuk pengelompokan gmbar dita
    private static List<Integer> dita =new ArrayList<Integer>(){{
        add(R.drawable.gmbr_dita1);
        add(R.drawable.gmbr_dita2);

    }};

    //membuat list array untuk pengelompokan gmbar obby
    private static List<Integer> obby =new ArrayList<Integer>(){{
        add(R.drawable.gmbr_1);
        add(R.drawable.gmbr_2);

    }};
   //method utk memanggil/mengambil variabel adita
   public static List<Integer> getDita(){
        return dita;
   }

    //method utk memanggil/mengambil variabel obby
    public static List<Integer> getObby(){
        return obby;
    }


}
