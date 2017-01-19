package com.example.andttapos.timestablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final int initializeValue = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.timesSeekBar);
        seekBar.setMax(20);
        seekBar.setProgress(initializeValue);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, this.getArrayOfnumber(initializeValue));

        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(adapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if(i!=0){
                    adapter.clear();
                    adapter.addAll(getArrayOfnumber(i));
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public ArrayList<String> getArrayOfnumber(int number){
        ArrayList<String> counter = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            int aValue = (i+1) * number;
            counter.add(Integer.toString(aValue));
        }
        return  counter;
    }

}
