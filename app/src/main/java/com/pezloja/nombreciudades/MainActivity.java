package com.pezloja.nombreciudades;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isChecking = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgCiudades = (RadioGroup) findViewById(R.id.btnCiudades);
        RadioGroup rgCiudades2 = (RadioGroup) findViewById(R.id.btnCiudades2);

        rgCiudades.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (isChecking) {  // Solo continuar si no estamos en proceso de desmarcar el otro grupo
                    isChecking = false;  // Desactivar el chequeo momentáneamente
                    if (checkedId == -1) {
                        System.out.println("No hay seleccionado ningúna ciudad en el primer grupo");
                    } else {
                        System.out.println("Ciudad seleccionada en el primer grupo: " +
                                ((RadioButton) group.findViewById(checkedId)).getText());
                        // Desmarcar el segundo RadioGroup
                        rgCiudades2.clearCheck();
                    }
                    isChecking = true;  // Reactivar el chequeo
                }
            }
        });

        rgCiudades2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (isChecking) {  // Solo continuar si no estamos en proceso de desmarcar el otro grupo
                    isChecking = false;  // Desactivar el chequeo momentáneamente
                    if (checkedId == -1) {
                        System.out.println("No hay seleccionado ningúna ciudad en el segundo grupo");
                    } else {
                        System.out.println("Ciudad seleccionada en el segundo grupo: " +
                                ((RadioButton) group.findViewById(checkedId)).getText());
                        // Desmarcar el primer RadioGroup
                        rgCiudades.clearCheck();
                    }
                    isChecking = true;  // Reactivar el chequeo
                }
            }
        });

    }

}