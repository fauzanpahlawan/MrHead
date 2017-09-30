package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentEyes extends Fragment implements View.OnClickListener {

    SendEvent mCallback;

    interface SendEvent {

        void setEyes(int resource, int visibility);
    }

    private ImageView[] buttonEyes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eyes, container, false);

        buttonEyes = new ImageView[6];
        buttonEyes[0] = view.findViewById(R.id.buttonEyesNone);
        buttonEyes[1] = view.findViewById(R.id.buttonEyesCircleBig);
        buttonEyes[2] = view.findViewById(R.id.buttonEyesLineNormal);
        buttonEyes[3] = view.findViewById(R.id.buttonEyesLongNormal);
        buttonEyes[4] = view.findViewById(R.id.buttonEyesLongWeak);
        buttonEyes[5] = view.findViewById(R.id.buttonEyesShut);

        for (ImageView iv : buttonEyes) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEyesNone:
                clearAll();
                buttonEyes[0].setBackgroundColor(Color.LTGRAY);
                buttonEyes[0].invalidate();
                setEyes(R.drawable.eyelinenormal, View.INVISIBLE);
                break;
            case R.id.buttonEyesCircleBig:
                clearAll();
                buttonEyes[1].setBackgroundColor(Color.LTGRAY);
                buttonEyes[1].invalidate();
                setEyes(R.drawable.eyecirclebig, View.VISIBLE);
                break;
            case R.id.buttonEyesLineNormal:
                clearAll();
                buttonEyes[2].setBackgroundColor(Color.LTGRAY);
                buttonEyes[2].invalidate();
                setEyes(R.drawable.eyelinenormal, View.VISIBLE);
                break;
            case R.id.buttonEyesLongNormal:
                clearAll();
                buttonEyes[3].setBackgroundColor(Color.LTGRAY);
                buttonEyes[3].invalidate();
                setEyes(R.drawable.eyelongnormal, View.VISIBLE);
                break;
            case R.id.buttonEyesLongWeak:
                clearAll();
                buttonEyes[4].setBackgroundColor(Color.LTGRAY);
                buttonEyes[4].invalidate();
                setEyes(R.drawable.eyelongweak, View.VISIBLE);
                break;
            case R.id.buttonEyesShut:
                clearAll();
                buttonEyes[5].setBackgroundColor(Color.LTGRAY);
                buttonEyes[5].invalidate();
                setEyes(R.drawable.eyeshut, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonEyes) {
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

    public void setEyes(int resource, int visibility) {
        mCallback.setEyes(resource, visibility);
    }


    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
