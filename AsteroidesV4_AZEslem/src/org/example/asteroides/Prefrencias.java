package org.example.asteroides;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Prefrencias extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferencias);
	}

}
