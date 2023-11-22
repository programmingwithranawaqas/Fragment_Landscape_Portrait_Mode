package com.example.frag_rev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.OnSelectedName {

    String []descriptions;
    TextView tvDesc;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descriptions = getResources()
                .getStringArray(R.array.descriptions);
        fragmentManager = getSupportFragmentManager();
        tvDesc = fragmentManager
                .findFragmentById(R.id.desfrag)
                .getView()
                .findViewById(R.id.tvDesc);

        if(findViewById(R.id.portrait)!=null)
        {
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listfrag))
                    .hide(fragmentManager.findFragmentById(R.id.desfrag))
                    .addToBackStack(null)
                    .commit();
        }
        if(findViewById(R.id.landscape)!=null)
        {
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listfrag))
                    .show(fragmentManager.findFragmentById(R.id.desfrag))

                    .commit();
        }

    }

    @Override
    public void onNameClick(int position) {
        tvDesc.setText(descriptions[position]);
        if(findViewById(R.id.portrait)!=null)
        {
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.listfrag))
                    .show(fragmentManager.findFragmentById(R.id.desfrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}