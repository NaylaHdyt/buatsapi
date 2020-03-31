package com.example.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private RelativeLayout mRelativeLayout;
    private TextView mtv;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mContext = MainActivity.this;
        mRelativeLayout = findViewById(R.id.rl);
        mtv = findViewById(R.id.textView);
        mtv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService (LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate (R.layout.custom_layout, null);

                mPopupWindow = new PopupWindow (
                        customView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                if (Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                ImageButton closeButton = customView.findViewById(R.id.ib_close);
                closeButton.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        mPopupWindow.dismiss ();
                    }
                });
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });
    }
}
