package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout l = new LinearLayout( this );
        l.setOrientation( LinearLayout.VERTICAL );
        setContentView( l );
        l.addView( new Screen(this) );
    }

}