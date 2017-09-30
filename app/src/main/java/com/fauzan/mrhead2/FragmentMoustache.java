package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentMoustache extends Fragment implements View.OnClickListener {
    SendEvent mCallback;

    interface SendEvent {

        void setMoustache(int resource, int visibility);

    }

    private ImageView[] buttonMoustaches;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moustache, container, false);

        buttonMoustaches = new ImageView[6];
        buttonMoustaches[0] = view.findViewById(R.id.buttonMoustacheNone);
        buttonMoustaches[1] = view.findViewById(R.id.buttonMoustacheHeavy);
        buttonMoustaches[2] = view.findViewById(R.id.buttonMoustacheNormal);
        buttonMoustaches[3] = view.findViewById(R.id.buttonMoustachePoint);
        buttonMoustaches[4] = view.findViewById(R.id.buttonMoustacheWavy);
        buttonMoustaches[5] = view.findViewById(R.id.buttonMoustacheWrinkled);

        for (ImageView iv : buttonMoustaches) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonMoustacheNone:
                clearAll();
                buttonMoustaches[0].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[0].invalidate();
                setMoustache(R.drawable.moustachenormal, View.INVISIBLE);
                break;
            case R.id.buttonMoustacheHeavy:
                clearAll();
                buttonMoustaches[1].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[1].invalidate();
                setMoustache(R.drawable.moustachewavy, View.VISIBLE);
                break;
            case R.id.buttonMoustacheNormal:
                clearAll();
                buttonMoustaches[2].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[2].invalidate();
                setMoustache(R.drawable.moustachenormal, View.VISIBLE);
                break;
            case R.id.buttonMoustachePoint:
                clearAll();
                buttonMoustaches[3].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[3].invalidate();
                setMoustache(R.drawable.moustachepoint, View.VISIBLE);
                break;
            case R.id.buttonMoustacheWavy:
                clearAll();
                buttonMoustaches[4].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[4].invalidate();
                setMoustache(R.drawable.moustachewavy, View.VISIBLE);
                break;
            case R.id.buttonMoustacheWrinkled:
                clearAll();
                buttonMoustaches[5].setBackgroundColor(Color.LTGRAY);
                buttonMoustaches[5].invalidate();
                setMoustache(R.drawable.moustachewrinkled, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonMoustaches) {
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

    public void setMoustache(int resource, int visibility) {
        mCallback.setMoustache(resource, visibility);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
