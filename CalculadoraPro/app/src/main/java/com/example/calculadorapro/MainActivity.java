package com.example.calculadorapro;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private String cuenta = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);

    }

    public void ponerNumero(View view){

        if(view.getId() == R.id.btn1){
            cuenta += "1";
        }else if(view.getId() == R.id.btn2){
            cuenta += "2";
        }
        else if(view.getId() == R.id.btn3){
            cuenta += "3";
        }
        else if(view.getId() == R.id.btn4){
            cuenta += "4";
        }
        else if(view.getId() == R.id.btn5){
            cuenta += "5";
        }
        else if(view.getId() == R.id.btn6){
            cuenta += "6";
        }
        else if(view.getId() == R.id.btn7){
            cuenta += "7";
        }
        else if(view.getId() == R.id.btn8){
            cuenta += "8";
        }
        else if(view.getId() == R.id.btn9){
            cuenta += "9";
        }
        else if(view.getId() == R.id.btn0){
            cuenta += "0";
        }
        else if(view.getId() == R.id.btn0){
            cuenta += "0";
        }
        else if(view.getId() == R.id.btnMultiplicar){
            cuenta += "*";
        }
        else if(view.getId() == R.id.btnDividir){
            cuenta += "/";
        }
        else if(view.getId() == R.id.btnSuma){
            cuenta += "+";
        }
        else if(view.getId() == R.id.btnResta){
            cuenta += "-";
        }
        else if(view.getId() == R.id.btnDecimal){
            cuenta += ".";
        }
        else if(view.getId() == R.id.btnIgual){
            hacerCuenta();
        }

       tvResultado.setText(cuenta);
    }

    private void hacerCuenta() {
//        int suma = 0;
//        for (int i=0;i<cuenta.length();i++){
//            if(cuenta.charAt(i) == '+'){
//                suma = cuenta.charAt(i-1) + cuenta.charAt(i+1);
//            }
//        }
//        tvResultado.setText(suma);
//        double resultado = eval(cuenta);
    }
}