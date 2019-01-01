package com.example.mypc.reminder_notes.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mypc.reminder_notes.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartsFragment extends Fragment {

    //variabel tag
    private static String TAG="BodyPartsFragments";
    public static final String IMAGE_ID_LIST="image_ids";
    public static final String LIST_INDEX="list_index";

    //untuk menyimpan variabel array beserta index
    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }


    //variabel global untuk memanggil list gambar dan fungsi setter
    private List<Integer> mImageIds;
    private Integer mListIndex;

    public void setmImageIds(List<Integer> mImageIds){
        this.mImageIds = mImageIds;
    }
    public void setmListIndex(Integer mListIndex){
        this.mListIndex=mListIndex;
    }

    //membuat konstraktor
    public BodyPartsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //jika tidak null maka variabel array dan index memanggal keadaan sebelumnya
        if(savedInstanceState!=null){
            mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex=savedInstanceState.getInt(LIST_INDEX);
        }

        //inisialisasi aktivity tersebut sebagai fragment
        View rootView=inflater.inflate(R.layout.body_part_layout_fragment, container, false);
        //mereferensi id yang ada di layout fragment
        final ImageView imageView= (ImageView) rootView.findViewById(R.id.imageView_body_part_layout_fragment);
        //ambil gambar untuk ditampilkan
        imageView.setImageResource(mImageIds.get(mListIndex));

        //fungsi untuk merubah index dari gambar yang terdapat pada ImageView tersebut.
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListIndex<mImageIds.size()-1){
                    mListIndex++;
                }
                else {
                    mListIndex=0;
                }
                imageView.setImageResource(mImageIds.get(mListIndex));
            }
        });
        return rootView;
    }

}

