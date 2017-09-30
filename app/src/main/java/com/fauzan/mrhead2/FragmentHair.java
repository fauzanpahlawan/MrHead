package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentHair extends Fragment implements View.OnClickListener {

    SendEvent mCallback;

    interface SendEvent {
        void setHair(int resource, int visibility);
    }

    private ImageView[] buttonHairs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hair, container, false);

        buttonHairs = new ImageView[6];
        buttonHairs[0] = view.findViewById(R.id.buttonnHairNone);
        buttonHairs[1] = view.findViewById(R.id.buttonHairWavy);
        buttonHairs[2] = view.findViewById(R.id.buttonHairShort);
        buttonHairs[3] = view.findViewById(R.id.buttonHairLong);
        buttonHairs[4] = view.findViewById(R.id.buttonHairAfro);
        buttonHairs[5] = view.findViewById(R.id.buttonHairPoint);

        for (ImageView iv : buttonHairs) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonnHairNone:
                clearAll();
                buttonHairs[0].setBackgroundColor(Color.LTGRAY);
                buttonHairs[0].invalidate();
                setHair(0, View.INVISIBLE);
                break;
            case R.id.buttonHairWavy:
                clearAll();
                buttonHairs[1].setBackgroundColor(Color.LTGRAY);
                buttonHairs[1].invalidate();
                setHair(0, View.VISIBLE);
                break;
            case R.id.buttonHairShort:
                clearAll();
                buttonHairs[2].setBackgroundColor(Color.LTGRAY);
                buttonHairs[2].invalidate();
                setHair(1, View.VISIBLE);
                break;
            case R.id.buttonHairLong:
                clearAll();
                buttonHairs[3].setBackgroundColor(Color.LTGRAY);
                buttonHairs[3].invalidate();
                setHair(2, View.VISIBLE);
                break;
            case R.id.buttonHairAfro:
                clearAll();
                buttonHairs[4].setBackgroundColor(Color.LTGRAY);
                buttonHairs[4].invalidate();
                setHair(3, View.VISIBLE);
                break;
            case R.id.buttonHairPoint:
                clearAll();
                buttonHairs[5].setBackgroundColor(Color.LTGRAY);
                buttonHairs[5].invalidate();
                setHair(4, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonHairs) {
            iv.setBackgroundColor(Color.TRANSPARENT);
            iv.invalidate();
        }
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mCallback = (SendEvent) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    public void setHair(int resource, int visibility) {
        mCallback.setHair(resource, visibility);
    }


    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
