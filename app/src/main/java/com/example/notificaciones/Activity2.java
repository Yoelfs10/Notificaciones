package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        EditText contenido=findViewById(R.id.editTextTextPersonName);
        SeekBar barra=findViewById(R.id.seekBar);
        Button vuelta=findViewById(R.id.button);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(barra.getProgress()==0 || barra.getProgress()<=3){
                    Toast toast= Toast.makeText(Activity2.this,"Abajo",Toast.LENGTH_LONG);
                    toast.show();
                }
                if(barra.getProgress()==4 || barra.getProgress()<=7){
                    Toast toast2= Toast.makeText(Activity2.this,"Medio",Toast.LENGTH_LONG);
                    toast2.show();
                }
                if(barra.getProgress()==8 || barra.getProgress()<=10){
                    Toast toast3= Toast.makeText(Activity2.this,"Arriba",Toast.LENGTH_LONG);
                    toast3.show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        contenido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Toast toast4= Toast.makeText(Activity2.this,contenido.getText().toString(),Toast.LENGTH_LONG);
                toast4.show();
            }
        });
        vuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}