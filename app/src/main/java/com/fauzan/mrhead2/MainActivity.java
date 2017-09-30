package com.fauzan.mrhead2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        FragmentHead.SendEvent, FragmentHair.SendEvent, FragmentEyeBrow.SendEvent,
        FragmentEyes.SendEvent, FragmentBeard.SendEvent, FragmentNose.SendEvent,
        FragmentMoustache.SendEvent {


    private ImageView imgVHead;
    private ImageView imgVEyes;
    private ImageView imgVEyeBrows;
    private ImageView imgVNose;
    private ImageView imgVBeard;
    private ImageView imgVMoustache;
    private ImageView[] imgVHairs;
    private Button[] buttons;
    private HorizontalScrollView horizontalScrollView;
    private Fragment FragmentHead, FragmentEyes, FragmentEyeBrow, FragmentHair, FragmentNose, FragmentBeard, FramentMoustache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentHead = new FragmentHead();
        FragmentHair = new FragmentHair();
        FragmentEyeBrow = new FragmentEyeBrow();
        FragmentEyes = new FragmentEyes();
        FragmentNose = new FragmentNose();
        FragmentBeard = new FragmentBeard();
        FramentMoustache = new FragmentMoustache();

        imgVHead = (ImageView) findViewById(R.id.imgVHead);
        imgVEyes = (ImageView) findViewById(R.id.imgVEyes);
        imgVEyes.setImageResource(R.drawable.eyelinenormal);

        imgVEyeBrows = (ImageView) findViewById(R.id.imgVEyeBrows);
        imgVEyeBrows.setImageResource(R.drawable.eyebrowlight);

        imgVNose = (ImageView) findViewById(R.id.imgVNose);
        imgVNose.setImageResource(R.drawable.nosenormal);

        imgVBeard = (ImageView) findViewById(R.id.imgVBeard);
        imgVBeard.setImageResource(R.drawable.beardshaved);

        imgVMoustache = (ImageView) findViewById(R.id.imgVMoustache);
        imgVMoustache.setImageResource(R.drawable.moustachenormal);

        imgVHairs = new ImageView[5];
        imgVHairs[0] = (ImageView) findViewById(R.id.imgVHairWavy);
        imgVHairs[1] = (ImageView) findViewById(R.id.imgVHairShort);
        imgVHairs[2] = (ImageView) findViewById(R.id.imgVHairLong);
        imgVHairs[3] = (ImageView) findViewById(R.id.imgVHairAfro);
        imgVHairs[4] = (ImageView) findViewById(R.id.imgVHairPoint);


        buttons = new Button[7];
        buttons[0] = (Button) findViewById(R.id.buttonHead);
        buttons[1] = (Button) findViewById(R.id.buttonHair);
        buttons[2] = (Button) findViewById(R.id.buttonEyeBrow);
        buttons[3] = (Button) findViewById(R.id.buttonEyes);
        buttons[4] = (Button) findViewById(R.id.buttonNose);
        buttons[5] = (Button) findViewById(R.id.buttonMoustache);
        buttons[6] = (Button) findViewById(R.id.buttonBeard);

        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);

        loadFragment(FragmentHead);

        clearAll();
        buttons[0].setBackgroundColor(Color.GRAY);
        buttons[0].invalidate();

        for (Button btn : buttons) {
            btn.setOnClickListener(this);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View v) {
        int scrollAmount = horizontalScrollView.getMaxScrollAmount() / 14;
        switch (v.getId()) {
            case R.id.buttonHead:
                horizontalScrollView.scrollTo(0, 0);
                clearAll();
                buttons[0].setBackgroundColor(Color.GRAY);
                buttons[0].invalidate();
                loadFragment(FragmentHead);
                break;
            case R.id.buttonHair:
                horizontalScrollView.scrollTo(0, 0);
                clearAll();
                buttons[1].setBackgroundColor(Color.GRAY);
                buttons[1].invalidate();
                loadFragment(FragmentHair);
                break;
            case R.id.buttonEyeBrow:
                horizontalScrollView.scrollTo(0, 0);
                clearAll();
                buttons[2].setBackgroundColor(Color.GRAY);
                buttons[2].invalidate();
                loadFragment(FragmentEyeBrow);
                break;
            case R.id.buttonEyes:
                horizontalScrollView.scrollTo(scrollAmount * 14, 0);
                clearAll();
                buttons[3].setBackgroundColor(Color.GRAY);
                buttons[3].invalidate();
                loadFragment(FragmentEyes);
                break;
            case R.id.buttonNose:
                horizontalScrollView.scrollTo(scrollAmount * 14, 0);
                clearAll();
                buttons[4].setBackgroundColor(Color.GRAY);
                buttons[4].invalidate();
                loadFragment(FragmentNose);
                break;
            case R.id.buttonMoustache:
                horizontalScrollView.scrollTo(scrollAmount * 14, 0);
                clearAll();
                buttons[5].setBackgroundColor(Color.GRAY);
                buttons[5].invalidate();
                loadFragment(FramentMoustache);
                break;
            case R.id.buttonBeard:
                horizontalScrollView.scrollTo(scrollAmount * 14, 0);
                clearAll();
                buttons[6].setBackgroundColor(Color.GRAY);
                buttons[6].invalidate();
                loadFragment(FragmentBeard);
                break;
        }
    }

    public void clearAll() {
        for (Button bt : buttons) {
            bt.setBackgroundColor(Color.LTGRAY);
            bt.invalidate();
        }
    }


    //Head
    @Override
    public void setHead(int resource, int visibility) {
        imgVHead.setImageResource(resource);
        imgVHead.setVisibility(visibility);
    }

    //Eyes
    @Override
    public void setEyes(int resource, int visibility) {
        imgVEyes.setImageResource(resource);
        imgVEyes.setVisibility(visibility);
    }

    //EyeBrow
    @Override
    public void setEyeBrow(int resource, int visibility) {
        imgVEyeBrows.setImageResource(resource);
        imgVEyeBrows.setVisibility(visibility);
    }

    //Nose
    @Override
    public void setNose(int resource, int visibility) {
        imgVNose.setImageResource(resource);
        imgVNose.setVisibility(visibility);

    }

    //Beard
    @Override
    public void setBeard(int resource, int visibility) {
        imgVBeard.setImageResource(resource);
        imgVBeard.setVisibility(visibility);
    }

    //Moustache
    @Override
    public void setMoustache(int resource, int visibility) {
        imgVMoustache.setImageResource(resource);
        imgVMoustache.setVisibility(visibility);

    }

    //Hair
    @Override
    public void setHair(int resource, int visibility) {
        for (ImageView hair : imgVHairs) {
            hair.setVisibility(View.INVISIBLE);
        }
        imgVHairs[resource].setVisibility(visibility);
    }
}
