package org.example.asteroides;

import java.util.Vector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class VistaJuego extends View {
	// //// ASTEROIDES //////
	private Vector<Grafico> Asteroides; // Vector con los Asteroides
	private int numAsteroides = 5; // N�mero inicial de asteroides
	private int numFragmentos = 3; // Fragmentos en que se divide

	// //// NAVE //////
	private Grafico nave;// Gr�fico de la nave
	private int giroNave; // Incremento de direcci�n
	private float aceleracionNave; // aumento de velocidad
	// Incremento est�ndar de giro y aceleraci�n
	private static final int PASO_GIRO_NAVE = 5;
	private static final float PASO_ACELERACION_NAVE = 0.5f;

	public VistaJuego(Context context, AttributeSet attrs) {
		super(context, attrs);
		Drawable drawableNave, drawableAsteroide, drawableMisil;
		drawableAsteroide = context.getResources().getDrawable(
				R.drawable.asteroide1);
		Asteroides = new Vector<Grafico>();
		for (int i = 0; i < numAsteroides; i++) {
			Grafico asteroide = new Grafico(this, drawableAsteroide);
			asteroide.setIncY(Math.random() * 4 - 2);
			asteroide.setIncX(Math.random() * 4 - 2);
			asteroide.setAngulo((int) (Math.random() * 360));
			asteroide.setRotacion((int) (Math.random() * 8 - 4));
			Asteroides.add(asteroide);
		}

		// Nave

		drawableNave = context.getResources().getDrawable(R.drawable.nave);
		nave = new Grafico(this, drawableNave);
		// Posicionamos la nave en el centro

	}

	@Override
	protected void onSizeChanged(int ancho, int alto, int ancho_anter,
			int alto_anter) {
		super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);
		// Posicionamos la nave en el centro
		nave.setCenX((int) ancho / 2);
		nave.setCenY((int) alto / 2);

		// A partir del posicionamiento de la nave posicionamos los asteroides
		for (Grafico asteroide : Asteroides) {
			do {
				asteroide.setCenX(Math.random()
						* (ancho - asteroide.getAncho()));
				asteroide.setCenY(Math.random() * (alto - asteroide.getAlto()));
			} while (asteroide.distancia(nave) < (ancho + alto) / 5);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (Grafico asteroide : Asteroides) {
			asteroide.dibujaGrafico(canvas);
		}
		nave.dibujaGrafico(canvas);
	}
}