package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentNose extends Fragment implements View.OnClickListener {
    SendEvent mCallback;

    interface SendEvent {

        void setNose(int resource, int visibility);

    }

    private ImageView[] buttonNoses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nose, container, false);

        buttonNoses = new ImageView[3];
        buttonNoses[0] = view.findViewById(R.id.buttonNoseNone);
        buttonNoses[1] = view.findViewById(R.id.buttonNoseNormal);
        buttonNoses[2] = view.findViewById(R.id.buttonNoseDot);

        for (ImageView iv : buttonNoses) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNoseNone:
                clearAll();
                buttonNoses[0].setBackgroundColor(Color.LTGRAY);
                buttonNoses[0].invalidate();
                setNose(R.drawable.nosenormal, View.INVISIBLE);
                break;
            case R.id.buttonNoseNormal:
                clearAll();
                buttonNoses[1].setBackgroundColor(Color.LTGRAY);
                buttonNoses[1].invalidate();
                setNose(R.drawable.nosenormal, View.VISIBLE);
                break;
            case R.id.buttonNoseDot:
                clearAll();
                buttonNoses[2].setBackgroundColor(Color.LTGRAY);
                buttonNoses[2].invalidate();
                setNose(R.drawable.nosedot, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonNoses) {
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

    public void setNose(int resource, int visibility) {
        mCallback.setNose(resource, visibility);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
