package com.example.criperrui.baccus.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.criperrui.baccus.R;
import com.example.criperrui.baccus.model.Wine;

/**
 * Created by criperrui on 24/03/2016.
 */
public class WineryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.activity_winery, container, false);
        Wine rivergate = new Wine("Rivergate",
                "Tinto",
                R.drawable.rivergate,
                "Dominio de Tares",
                "https://www.cristinaperea.es",
                "Un vino de gran categoría que no sabe a nada pero que te cobran por la botella así como unos 50 euros...pero no te preocupes, " +
                        "si lo que quieres es la borrachera te la coges igual. \"Un vino de gran categoría que no sabe a nada pero que te cobran" +
                        " por la botella así como unos 50 euros...pero no te preocupes, si lo que quieres es la borrachera te la coges igual. " +
                        "Un vino de gran categoría que no sabe a nada pero que te cobran por la botella así como unos 50 euros...pero no te" +
                        " preocupes, si lo que quieres es la borrachera te la coges igual.",
                "Valdepeñas",
                5);
        rivergate.addGrape("Mecía");

        Wine vegaval = new Wine("Vegaval",
                "Tinto",
                R.drawable.vinuvas,
                "Miguel de Calatayud",
                "https://www.vegaval.com/es",
                "Un vino de gran categoría que no sabe a nada pero que te cobran por la botella así como unos 50 euros...pero no te preocupes, " +
                        "si lo que quieres es la borrachera te la coges igual.",
                "El Bierzo",
                3);
        vegaval.addGrape("Tempranillo");

        FragmentTabHost tabHost= (FragmentTabHost) root.findViewById(android.R.id.tabhost);
        tabHost.setup(getActivity(), getActivity().getSupportFragmentManager(), android.R.id.tabhost);

        Bundle arguments = new Bundle();
        arguments.putSerializable(WineFragment.ARG_WINE, rivergate);
        tabHost.addTab(tabHost.newTabSpec(rivergate.getName()).setIndicator(rivergate.getName()), WineFragment.class, arguments);


        arguments = new Bundle();
        arguments.putSerializable(WineFragment.ARG_WINE, vegaval);
        tabHost.addTab(tabHost.newTabSpec(vegaval.getName()).setIndicator(vegaval.getName()), WineFragment.class, arguments);


        return root;
    }
}
