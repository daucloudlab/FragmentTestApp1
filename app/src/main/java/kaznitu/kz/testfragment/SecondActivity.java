package kaznitu.kz.testfragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kaznitu.kz.fragments.Fragment2;

public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent() ;
        int buttonIndex = intent.getIntExtra("buttonIndex", -1) ;
        if(buttonIndex != -1){
            FragmentManager fm = getFragmentManager() ;
            Fragment2 fragment2 = (Fragment2)fm.findFragmentById(R.id.fragment2) ;
            fragment2.setDescription(buttonIndex);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
    }
}
