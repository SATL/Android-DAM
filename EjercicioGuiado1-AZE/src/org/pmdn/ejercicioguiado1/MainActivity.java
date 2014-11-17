package org.pmdn.ejercicioguiado1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText p_et1, p_et2;
	private TextView p_tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		p_et1 = (EditText) findViewById(R.id.et1);
		p_et2 = (EditText) findViewById(R.id.et2);
		p_tv3 = (TextView) findViewById(R.id.tv3);
	}
	
	public void sumar(View view){
		
		String valor1= p_et1.getText().toString();
		String valor2= p_et2.getText().toString();
		
		int nro1 = Integer.parseInt(valor1);
		int nro2 = Integer.parseInt(valor2);
		
		int suma = nro1 + nro2;
		
		String resu = String.valueOf(suma);
		p_tv3.setText(resu);
	}
}
