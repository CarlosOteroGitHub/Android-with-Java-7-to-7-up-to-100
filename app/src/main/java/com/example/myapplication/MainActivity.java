package com.example.myapplication;

/*

Author: ING. CARLOS OTERO RAMÍREZ

 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int opcion;
    String guardar="";

    private EditText editText1;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Mostrar Números de 7 en 7 al 100");

        editText1 = findViewById(R.id.AM1_id2);
        button1 = findViewById(R.id.AM1_id3);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.AM1_id4);
        button2.setOnClickListener(this);
    }

    public void dialogoAlerta(String titulo, String mensaje){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AM1_id3:
                if(editText1.getText().toString().isEmpty()){
                    dialogoAlerta("Mensaje de Error", "El Campo de Texto esta Vacio");
                } else {
                    if(Integer.parseInt(editText1.getText().toString()) != 1 && Integer.parseInt(editText1.getText().toString()) != 2){
                        dialogoAlerta("Mensaje de Error", "Opción ingresada no valida");
                    } else {
                        opcion=Integer.parseInt(editText1.getText().toString());
                        if(opcion == 1){
                            for(int i=7; i<=100; i=i+7){
                                guardar+=i+" ";
                            }
                            dialogoAlerta("Mensaje de Información", "Utilizo for: " + guardar);
                        } else {
                            int i=7;
                            while(i<=100){
                                guardar+=i+" ";
                                i=i+7;
                            }
                            dialogoAlerta("Mensaje de Información", "Utilizo while: " + guardar);
                        }
                    }
                }
                break;
            case R.id.AM1_id4:
                System.exit(0);
                break;
        }
    }
}