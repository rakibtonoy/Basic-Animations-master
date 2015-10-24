package com.alexchengalan.basicanimations;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BasicAnimationsMain extends Activity {

	TextView animationName;
	ImageView animationPic;
	Button scaleButton, translateButton, rotateButton, alphaButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_animations_main);

		animationName = (TextView) findViewById(R.id.animationName);
		animationPic = (ImageView) findViewById(R.id.animationPicture);

		scaleButton = (Button) findViewById(R.id.scaleButton);
		translateButton = (Button) findViewById(R.id.translateButton);
		rotateButton = (Button) findViewById(R.id.rotateButton);
		alphaButton = (Button) findViewById(R.id.alphaButton);

		scaleButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ScaleAnimation scaleAnimation = new ScaleAnimation((float) 1.0,
						(float) 0.0, (float) 1.0, (float) 0.0);
				scaleAnimation.setFillAfter(true);
				scaleAnimation.setRepeatCount(100);
				scaleAnimation.setDuration(1000);
				animationPic.startAnimation(scaleAnimation);
				animationName.setText("Scale Animation");
			}
		});

		translateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TranslateAnimation translateAnimation = new TranslateAnimation(
						Animation.RELATIVE_TO_PARENT, 0,
						Animation.RELATIVE_TO_PARENT, 0, Animation.ABSOLUTE,
						350, Animation.ABSOLUTE, 0);
				translateAnimation.setDuration(1000);
				translateAnimation.setRepeatCount(100);
				translateAnimation.reset();
				translateAnimation.setFillAfter(true);
				animationPic.startAnimation(translateAnimation);
				animationName.setText("Translate Animation");
			}
		});

		rotateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RotateAnimation rotateAnimation = new RotateAnimation(0f, 350f,
						15f, 15f);
				rotateAnimation.setInterpolator(new LinearInterpolator());
				rotateAnimation.setRepeatCount(Animation.INFINITE);
				rotateAnimation.setDuration(1000);
				animationPic.startAnimation(rotateAnimation);
				animationName.setText("Rotate Animation");
			}
		});

		alphaButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Animation alphaAnimation = new AlphaAnimation(1, 0);
				alphaAnimation.setDuration(1000);
				alphaAnimation.setInterpolator(new LinearInterpolator());
				alphaAnimation.setRepeatCount(Animation.INFINITE);
				alphaAnimation.setRepeatMode(Animation.REVERSE);
				animationPic.startAnimation(alphaAnimation);
				animationName.setText("Alpha Animation");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basic_animations_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {

		case R.id.action_stop:
			animationPic.clearAnimation();
			animationName.setText("");
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
