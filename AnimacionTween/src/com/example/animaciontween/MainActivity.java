package com.example.animaciontween;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView texto = (TextView) findViewById(R.id.textView);
		Animation animacion = AnimationUtils.loadAnimation(this,
				R.anim.animacion);
		texto.startAnimation(animacion);
	}
}
