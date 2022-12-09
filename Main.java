package com.example.project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Main extends Fragment implements RecycleViewInterface {
    private ArrayList<DataModel> dataSet;
    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Main.
     */
    // TODO: Rename and change types and number of parameters
    public static Main newInstance(String param1, String param2) {
        Main fragment = new Main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recycleView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(layoutManager);
        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();
        for(int i=0 ; i<MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    //MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]


            ));
        }
        CustomAdapter addapter = new CustomAdapter(getContext(),dataSet,this);
        recycleView.setAdapter(addapter);

        return view;
    }

    @Override
    public void onItemClick(int pos, View view) {
        String[] strArr = {"Recipient of the Super Soldier serum, World War II hero Steve Rogers fights for American ideals as one of the world's mightiest heroes and the leader of the Avengers. America's World War II Super-Soldier continues his fight in the present as an Avenger and untiring sentinel of liberty."
                , "In Norse mythology, he is a hammer-wielding god associated with lightning, thunder, storms, sacred groves and trees, strength, the protection of humankind, hallowing, and fertility."
                , "'The Incredible Hulk' tells the story of Dr Bruce Banner, who seeks a cure to his unique condition, which causes him to turn into a giant green monster under emotional stress. Whilst on the run from military which seeks his capture, Banner comes close to a cure."
                , "He is the Armored Avenger - driven by a heart that is part machine, but all hero! He is the INVINCIBLE IRON MAN! Iron Man's Powers and Abilities: Wears modular arc reactor-powered Iron Man armor, granting superhuman strength & durability, the ability to fly & project Repulsor blasts."};
        int[] imgArr = {R.drawable.cptainamerica,R.drawable.thorr,R.drawable.greenh,R.drawable.ironman};
        Bundle bundle = new Bundle();
        bundle.putString("description",strArr[pos]);
        bundle.putInt("image",imgArr[pos]);
        getParentFragmentManager().setFragmentResult("bundle",bundle);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.moveToSecondFrag();
    }
}