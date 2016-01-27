package kaznitu.kz.testfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import kaznitu.kz.fragments.Fragment1;
import kaznitu.kz.fragments.Fragment2;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {
    private boolean mIsDynamic ;
    @Override
    public void onButtonSelected(int buttonIndex) {
        FragmentManager fm = getFragmentManager() ;

        Fragment2 fragment2 = (Fragment2)fm.findFragmentById(R.id.fragment2) ;

        if(fragment2 == null || !fragment2.isVisible()){
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class) ;
            intent.putExtra("buttonIndex", buttonIndex) ;
            startActivity(intent);
        }else {
            fragment2.setDescription(buttonIndex);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager() ;
        Fragment1 fragment11 = (Fragment1)fm.findFragmentById(R.id.fragment1) ;
        mIsDynamic = fragment11 == null || !fragment11.isInLayout() ;
        if(mIsDynamic){
            FragmentTransaction ft = fm.beginTransaction() ;
            ft.add(R.id.container, new Fragment1(), "fragment1") ;
            ft.commit() ;
        }
    }
}
