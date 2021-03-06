package org.example.asteroides;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Asteroides extends Activity {

	Button bAcercaDe;
	Button bSalir;
	Button bPreferencias;
	Button bPuntuaciones;
	Button bJugar;

	TextView titulo;

	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * LinearLayout vistaPrincipal = (LinearLayout)
		 * this.findViewById(R.id.LinearLayout1);
		 * vistaPrincipal.setBackgroundResource(R.drawable.degradado);
		 */

		// Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

		titulo = (TextView) findViewById(R.id.titulo);
		bAcercaDe = (Button) findViewById(R.id.button3);
		bSalir = (Button) findViewById(R.id.button4);
		bPreferencias = (Button) findViewById(R.id.button2);
		bPuntuaciones = (Button) findViewById(R.id.button5);
		bJugar = (Button) findViewById(R.id.button1);

		bJugar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarJuego(v);
			}
		});

		bPuntuaciones.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarPuntuaciones(null);
			}
		});

		bPreferencias.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarpreferencias(null);
			}
		});

		bAcercaDe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				lanzarAcercaDe(null);
			}

		});

		bSalir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				salir(null);
			}
		});

		animaciones();
	}

	public void animaciones() {
		Animation animacion = AnimationUtils.loadAnimation(this,
				R.anim.giro_con_zoom);
		titulo.startAnimation(animacion);
		
		Animation aparecer = AnimationUtils.loadAnimation(this, R.anim.aparecer);
		bJugar.startAnimation(aparecer);
		
		Animation desplazar = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_derecha);
		bPreferencias.startAnimation(desplazar);
	}

	public void lanzarAcercaDe(View view) {
		Intent intent = new Intent(this, AcercaDe.class);
		startActivity(intent);

	}

	public void lanzarpreferencias(View view) {
		Intent intent = new Intent(this, Prefrencias.class);
		startActivity(intent);

	}

	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}

	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivity(i);
	}

	public void salir(View view) {
		finish();
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		// Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
		// Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		// Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.acercaDe:
			lanzarAcercaDe(null);
			break;

		case R.id.config:
			lanzarpreferencias(null);
			break;

		}

		return true;
	}

}
