package com.example.pruebas1erapractica;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
    }

    public void sumar(View view){
        String text1 = et1.getText().toString();
        String text2 = et2.getText().toString();

        int num1 = Integer.parseInt(text1);
        int num2 = Integer.parseInt(text2);

        int resultado = num1 + num2;

        tv1.setText(String.valueOf(resultado));

    }

    public void restar(View view){
        String text1 = et1.getText().toString();
        String text2 = et2.getText().toString();

        int num1 = Integer.parseInt(text1);
        int num2 = Integer.parseInt(text2);

        int resultado = num1 - num2;

        tv1.setText(String.valueOf(resultado));

    }

    public void multiplicar(View view){
        String text1 = et1.getText().toString();
        String text2 = et2.getText().toString();

        int num1 = Integer.parseInt(text1);
        int num2 = Integer.parseInt(text2);

        int resultado = num1 * num2;

        tv1.setText(String.valueOf(resultado));

    }

    public void dividir(View view){
        String text1 = et1.getText().toString();
        String text2 = et2.getText().toString();

        int num1 = Integer.parseInt(text1);
        int num2 = Integer.parseInt(text2);

        double resultado = (double) num1 / num2;

        tv1.setText(String.valueOf(resultado));

    }

}