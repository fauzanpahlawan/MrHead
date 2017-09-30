package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentEyeBrow extends Fragment implements View.OnClickListener {

    SendEvent mCallback;

    interface SendEvent {

        void setEyeBrow(int resource, int visibility);

    }

    private ImageView[] buttonEyeBrows;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eye_brow, container, false);

        buttonEyeBrows = new ImageView[3];
        buttonEyeBrows[0] = view.findViewById(R.id.buttonEyeBrowNone);
        buttonEyeBrows[1] = view.findViewById(R.id.buttonEyeBrowLight);
        buttonEyeBrows[2] = view.findViewById(R.id.buttonEyeBrowHeavy);

        for (ImageView iv : buttonEyeBrows) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEyeBrowNone:
                clearAll();
                buttonEyeBrows[0].setBackgroundColor(Color.LTGRAY);
                buttonEyeBrows[0].invalidate();
                setEyeBrow(R.drawable.eyebrowheavy, View.INVISIBLE);
                break;
            case R.id.buttonEyeBrowLight:
                clearAll();
                buttonEyeBrows[1].setBackgroundColor(Color.LTGRAY);
                buttonEyeBrows[1].invalidate();
                setEyeBrow(R.drawable.buttoneyebrowlight, View.VISIBLE);
                break;
            case R.id.buttonEyeBrowHeavy:
                clearAll();
                buttonEyeBrows[2].setBackgroundColor(Color.LTGRAY);
                buttonEyeBrows[2].invalidate();
                setEyeBrow(R.drawable.buttoneyebrowheavy, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonEyeBrows) {
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

    public void setEyeBrow(int resource, int visibility) {
        mCallback.setEyeBrow(resource, visibility);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
