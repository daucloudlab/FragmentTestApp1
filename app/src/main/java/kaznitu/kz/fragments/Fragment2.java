package kaznitu.kz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kaznitu.kz.testfragment.R;


public class Fragment2 extends Fragment {
    public static final String BUTTON_INDEX = "button_index" ;
    public static final int BUTTON_INDEX_DEFAULT = -1 ;

    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false) ;

        mInfoTextView = (TextView) rootView.findViewById(R.id.textView1);
        mCatImageView = (ImageView) rootView.findViewById(R.id.imageView1);

        mCatDescriptionArray = getResources().getStringArray(R.array.cats) ;

        Bundle args = getArguments() ;
        int buttonIndex = args != null ? args.getInt(BUTTON_INDEX, BUTTON_INDEX_DEFAULT)
                : BUTTON_INDEX_DEFAULT ;
        if(buttonIndex != BUTTON_INDEX_DEFAULT)
            setDescription(buttonIndex);

        return rootView ;
    }

    public void setDescription(int buttonIndex) {
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.cat_yellow);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.cat_white);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.cat_green);
                break;

            default:
                break;
        }
    }
}
