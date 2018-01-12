package com.example.salman.assignment_test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Fragment extends Fragment{


    RecyclerView recyclerView;
    View view;

    public Contact_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_, container, false);

        // Custom Data Source

        ArrayList<Contact> arrayList = new ArrayList<Contact>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new Contact(i,"Name =" + i,"Email =" + i,"Phone = 12345" + i));
        }


        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(),arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(customAdapter);

        return view;
    }
}
