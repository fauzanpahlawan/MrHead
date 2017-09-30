package com.fauzan.mrhead2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentHead extends Fragment implements View.OnClickListener {

    SendEvent mCallback;

    interface SendEvent {
        void setHead(int resource, int visibility);
    }

    private ImageView[] buttonHeads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_head, container, false);

        buttonHeads = new ImageView[5];
        buttonHeads[0] = view.findViewById(R.id.buttonHeadNone);
        buttonHeads[1] = view.findViewById(R.id.buttonHeadPale);
        buttonHeads[2] = view.findViewById(R.id.buttonHeadBrown);
        buttonHeads[3] = view.findViewById(R.id.buttonHeadBright);
        buttonHeads[4] = view.findViewById(R.id.buttonHeadDark);

        for (ImageView iv : buttonHeads) {
            iv.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonHeadNone:
                clearAll();
                buttonHeads[0].setBackgroundColor(Color.LTGRAY);
                buttonHeads[0].invalidate();
                setHead(R.drawable.headpale, View.INVISIBLE);
                break;
            case R.id.buttonHeadPale:
                clearAll();
                buttonHeads[1].setBackgroundColor(Color.LTGRAY);
                buttonHeads[1].invalidate();
                setHead(R.drawable.headpale, View.VISIBLE);
                break;
            case R.id.buttonHeadBrown:
                clearAll();
                buttonHeads[2].setBackgroundColor(Color.LTGRAY);
                buttonHeads[2].invalidate();
                setHead(R.drawable.headbrown, View.VISIBLE);
                break;
            case R.id.buttonHeadBright:
                clearAll();
                buttonHeads[3].setBackgroundColor(Color.LTGRAY);
                buttonHeads[3].invalidate();
                setHead(R.drawable.headbright, View.VISIBLE);
                break;
            case R.id.buttonHeadDark:
                clearAll();
                buttonHeads[4].setBackgroundColor(Color.LTGRAY);
                buttonHeads[4].invalidate();
                setHead(R.drawable.headdark, View.VISIBLE);
                break;
        }
    }

    public void clearAll() {
        for (ImageView iv : buttonHeads) {
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

    public void setHead(int resource, int visibility) {
        mCallback.setHead(resource, visibility);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

}