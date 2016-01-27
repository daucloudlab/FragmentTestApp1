package kaznitu.kz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kaznitu.kz.testfragment.R;


public class Fragment1 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false) ;

        Button button1 = (Button)rootView.findViewById(R.id.button1) ;
        Button button2 = (Button)rootView.findViewById(R.id.button2) ;
        Button button3 = (Button)rootView.findViewById(R.id.button3) ;

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        return rootView ;
    }

    @Override
    public void onClick(View v) {

        int buttonIndex = translateIdToIndex(v.getId()) ;
        OnSelectedButtonListener listener = (OnSelectedButtonListener)getActivity() ;
        listener.onButtonSelected(buttonIndex);

        Toast.makeText(getActivity(), String.valueOf(buttonIndex), Toast.LENGTH_SHORT).show();

    }

    public int translateIdToIndex(int id){
        int index = -1 ;
        switch (id){
            case R.id.button1:
                index = 1 ;
                break ;
            case R.id.button2:
                index = 2 ;
                break ;
            case R.id.button3:
                index = 3 ;
                break ;
        }
        return index ;
    }

    public interface OnSelectedButtonListener{
        void onButtonSelected(int buttonIndex) ;
    }

}
