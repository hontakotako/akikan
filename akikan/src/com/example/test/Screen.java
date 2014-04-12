package com.example.test;

import android.view.View;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.graphics.*;
import java.util.Random;

public class Screen extends View
{
	float x , y;
	private final float positionx = 150 , positiony = 150;
	Paint p = new Paint();
	Bitmap back , akikan[] = new Bitmap[5];
	Rect src;
	private int hitflag = 0;
	private short hp = 15;
	
	public Screen( Context context )
	{
		super( context );
		Resources res = this.getContext().getResources();
		back = BitmapFactory.decodeResource(res, R.drawable.back);
		akikan[0] = BitmapFactory.decodeResource(res, R.drawable.akikan);
		akikan[1] = BitmapFactory.decodeResource(res, R.drawable.akikan2);
		akikan[2] = BitmapFactory.decodeResource(res, R.drawable.akikan3);
		akikan[3] = BitmapFactory.decodeResource(res, R.drawable.akikan4);
		akikan[4] = BitmapFactory.decodeResource(res, R.drawable.akikan5);
		src = new Rect( 0 , 0 , akikan[0].getWidth() , akikan[0].getHeight() );
	}
	
	public boolean onTouchEvent( MotionEvent ev )
	{
		if( ev.getAction() == MotionEvent.ACTION_DOWN )
		{
			x = ev.getX();
			y = ev.getY();
			if( x > positionx && x < positionx+akikan[0].getWidth() )
			{
				if( y > positiony && y < positiony+akikan[0].getHeight() )
				{
					hitflag = 2;
					if( hp > -1  )
						hp--;
				}
			}
			//Screen.this.invalidate();
		}
		return true;
	}
	
	private int vibration()
	{
		Random r = new Random();
		int result;
		result = r.nextInt( 50 ) - r.nextInt( 50 );
		return result;
	}
	
	private void akikanDraw( Canvas c )
	{
		float drawx = positionx , drawy = positiony;
		if( hitflag > 0 )
		{
			//Random r = new Random();
			if( hp > 12 ) { c.drawBitmap(akikan[0], drawx+vibration(), drawy+vibration() , p); hitflag--; }
	   else if( hp > 9 )  { c.drawBitmap(akikan[1], drawx+vibration(), drawy+vibration() , p); hitflag--; }
	   else if( hp > 6 )  { c.drawBitmap(akikan[2], drawx+vibration(), drawy+vibration() , p); hitflag--; }
	   else if( hp > 1 )  { c.drawBitmap(akikan[3], drawx+vibration(), drawy+vibration() , p); hitflag--; }
	   else				  { c.drawBitmap(akikan[4], drawx+vibration(), drawy+vibration() , p); hitflag--; }
		}
		else
		{
			if( hp > 12 ) c.drawBitmap( akikan[0] , positionx , positiony , p );
	   else if( hp > 9 )  c.drawBitmap( akikan[1] , positionx , positiony , p );
	   else if( hp > 6 )  c.drawBitmap( akikan[2] , positionx , positiony , p );
	   else if( hp > 1 )  c.drawBitmap( akikan[3] , positionx , positiony , p );
	   else 			  c.drawBitmap( akikan[4] , positionx , positiony , p );
		}
	}
	
	protected void onDraw( Canvas c )
	{
		super.onDraw( c );
		c.drawColor( Color.BLUE );
		
		c.drawBitmap( back , 0 , 0 , p );
		
		akikanDraw( c );
		Screen.this.invalidate();
	}
}
