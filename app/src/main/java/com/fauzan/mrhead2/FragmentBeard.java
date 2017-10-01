package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentBeard extends Fragment implements View.OnClickListener {

    SendEvent mCallback;

    interface SendEvent {

        void setBeard(int resource, int visibility);

    }

    private ImageView[] buttonBeards;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beard, container, false);

        buttonBeards = new ImageView[5];
        buttonBeards[0] = view.findViewById(R.id.buttonBeardNone);
        buttonBeards[1] = view.findViewById(R.id.buttonBeardMoustacheHeavy);
        buttonBeards[2] = view.findViewById(R.id.buttonBeardMoustacheNormal);
        buttonBeards[3] = view.findViewById(R.id.buttonBeardShaved);
        buttonBeards[4] = view.findViewById(R.id.buttonBeardSingleHair);

        for (ImageView iv : buttonBeards) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBeardNone:
                clearAll();
                buttonBeards[0].setBackgroundColor(Color.LTGRAY);
                buttonBeards[0].invalidate();
                setBeard(R.drawable.beardmoustachenormal, View.INVISIBLE);
                break;
            case R.id.buttonBeardMoustacheHeavy:
                clearAll();
                buttonBeards[1].setBackgroundColor(Color.LTGRAY);
                buttonBeards[1].invalidate();
                setBeard(R.drawable.beardmoustacheheavy, View.VISIBLE);
                break;
            case R.id.buttonBeardMoustacheNormal:
                clearAll();
                buttonBeards[2].setBackgroundColor(Color.LTGRAY);
                buttonBeards[2].invalidate();
                setBeard(R.drawable.beardmoustachenormal, View.VISIBLE);
                break;
            case R.id.buttonBeardShaved:
                clearAll();
                buttonBeards[3].setBackgroundColor(Color.LTGRAY);
                buttonBeards[3].invalidate();
                setBeard(R.drawable.beardshaved, View.VISIBLE);
                break;
            case R.id.buttonBeardSingleHair:
                clearAll();
                buttonBeards[4].setBackgroundColor(Color.LTGRAY);
                buttonBeards[4].invalidate();
                setBeard(R.drawable.beardsinglehair, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonBeards) {
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

    public void setBeard(int resource, int visibility) {
        mCallback.setBeard(resource, visibility);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
