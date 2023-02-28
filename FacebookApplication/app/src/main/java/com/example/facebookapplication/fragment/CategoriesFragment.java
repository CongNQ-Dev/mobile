package com.example.facebookapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.facebookapplication.CategoriesAdapter;
import com.example.facebookapplication.CategoriesModel;
import com.example.facebookapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    private ArrayList<CategoriesModel> categories = new ArrayList<>();
    int[] featureImages = {R.drawable.ic_pharmacy, R.drawable.ic_baby, R.drawable.ic_cart, R.drawable.ic_home,
            R.drawable.ic_pharmacy, R.drawable.ic_baby, R.drawable.ic_cart, R.drawable.ic_home};

    String[] featurePhoneNumber = {"19000001","19000002","19000003","19000004","19000001","19000002","19000003","19000004"};

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
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
        setUpFeatureModels();
        categoriesAdapter = new CategoriesAdapter(getContext(), categories);
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.mRecycleView);
        recyclerView.setAdapter(categoriesAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    private void setUpFeatureModels(){
        String[] featureName = {"Pharmacy","Baby","Cartwheel","Home","Pharmacy","Baby","Cartwheel","Home"};

        for (int i = 0; i < featureName.length; i++) {
            categories.add(new CategoriesModel(featureName[i], featureImages[i], featurePhoneNumber[i]));
        }
    }
}