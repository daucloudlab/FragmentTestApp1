package kaznitu.kz.testfragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kaznitu.kz.fragments.Fragment1;
import kaznitu.kz.fragments.Fragment2;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    @Override
    public void onButtonSelected(int buttonIndex) {
        FragmentManager fm = getFragmentManager() ;

        Fragment2 fragment2 = (Fragment2)fm.findFragmentById(R.id.fragment2) ;

        if(fragment2 != null)
            fragment2.setDescription(buttonIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
