package com.example.criperrui.baccus.controller.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TabHost;

import com.example.criperrui.baccus.R;
import com.example.criperrui.baccus.controller.fragment.WineryFragment;
import com.example.criperrui.baccus.model.Wine;


public class WineryActivity extends FragmentContainerActivity{

    @Override
    protected Fragment createFragment() {
        return new WineryFragment();
    }
}

/*public class WineryActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winery);

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


        TabHost tabHost = getTabHost();

        //Creamos la primera pestaña
        Intent intent = new Intent(this, WineActivity.class);
        intent.putExtra(WineActivity.EXTRA_WINE, rivergate);
        TabHost.TabSpec spec = tabHost
                .newTabSpec(rivergate.getName())
                .setIndicator(rivergate.getName())
                .setContent(intent);

        tabHost.addTab(spec);

        //Creamos la segunda pestaña
        intent = new Intent(this, WineActivity.class);
        intent.putExtra(WineActivity.EXTRA_WINE, vegaval);
        spec = tabHost
                .newTabSpec(vegaval.getName())
                .setIndicator(vegaval.getName())
                .setContent(intent);

        tabHost.addTab(spec);

    }
}*/
