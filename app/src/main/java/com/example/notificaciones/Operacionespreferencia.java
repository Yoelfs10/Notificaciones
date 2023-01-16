package com.example.notificaciones;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Operacionespreferencia extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
