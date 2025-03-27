package com.example.secondproj;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Integer firstCount = 0;
    Integer secondCount = 0;
    public void onRedClick(View view){
        firstCount++;
        TextView tv = findViewById(R.id.red_count);
        tv.setText(firstCount.toString());
    }
    public void onBlueClick(View view){
        secondCount++;
        TextView tv = findViewById(R.id.blue_count);
        tv.setText(secondCount.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putInt("count1", firstCount);
        outstate.putInt("count2", secondCount);
        Log.d("Instance", "Saved");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        super.onRestoreInstanceState(savedInstance);
        if(savedInstance!=null && savedInstance.containsKey("count1")){
            firstCount=savedInstance.getInt("count1");
            TextView tv = findViewById(R.id.red_count);
            tv.setText(firstCount.toString());
        }
        if(savedInstance!=null && savedInstance.containsKey("count2")){
            secondCount=savedInstance.getInt("count2");
            TextView tv = findViewById(R.id.blue_count);
            tv.setText(secondCount.toString());
        }
    }
}