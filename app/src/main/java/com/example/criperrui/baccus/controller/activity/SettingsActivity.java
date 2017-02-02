package com.example.criperrui.baccus.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.criperrui.baccus.R;
import com.example.criperrui.baccus.controller.fragment.SettingsFragment;


/**
 * Created by criperrui on 17/03/2016.
 */


public class SettingsActivity extends FragmentContainerActivity{
    public static final String EXTRA_WINE_IMAGE_SCALE_TYPE = "com.example.criperrui.baccus.controller.activity.SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE";


    @Override
    protected Fragment createFragment() {
        Bundle arguments = new Bundle();
        arguments.putSerializable(SettingsFragment.ARG_WINE_IMAGE_SCALE_TYPE, getIntent().getSerializableExtra(EXTRA_WINE_IMAGE_SCALE_TYPE));
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(arguments);

        return fragment;
    }
}
/*public class SettingsActivity extends Activity implements View.OnClickListener{
    public static final String EXTRA_WINE_IMAGE_SCALE_TYPE = "com.example.criperrui.baccus.controller.activity.SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE";
    private RadioGroup mRadioGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_settings);

        mRadioGroup = (RadioGroup)findViewById(R.id.scale_type_radios);

        if(getIntent().getSerializableExtra(EXTRA_WINE_IMAGE_SCALE_TYPE).equals(ImageView.ScaleType.FIT_XY)){
            mRadioGroup.check(R.id.fit_radio);
        }else if(getIntent().getSerializableExtra(EXTRA_WINE_IMAGE_SCALE_TYPE).equals(ImageView.ScaleType.FIT_CENTER)) {
            mRadioGroup.check(R.id.center_radio);
        }


        Button cancelButton = (Button)findViewById(R.id.cancel_button);
        Button saveButton = (Button) findViewById(R.id.save_button);

        cancelButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.cancel_button:
                cancelSettings();
                break;
            case R.id.save_button:
                saveSettings();
                break;

        }
    }

    private void saveSettings() {
       Intent config = new Intent();
        if(mRadioGroup.getCheckedRadioButtonId() == R.id.fit_radio){
            config.putExtra(EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_XY);
        }else if(mRadioGroup.getCheckedRadioButtonId() == R.id.center_radio){
            config.putExtra(EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_CENTER);
        }
        setResult(RESULT_OK, config);
        finish();
    }

    private void cancelSettings() {
        setResult(RESULT_CANCELED);
        finish();
    }
    
    
}*/
