package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;

    private TextView text3;
    private char operador;
    private float numero1;
    private float numero2;

    private int punto=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Obtén referencias a los TextViews
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        // Obtén referencias a los botones
        TextView boton1 = findViewById(R.id.boton_1);
        TextView boton2 = findViewById(R.id.boton_2);
        TextView boton3 = findViewById(R.id.boton_3);
        TextView boton4 = findViewById(R.id.boton_4);
        TextView boton5 = findViewById(R.id.boton_5);
        TextView boton6 = findViewById(R.id.boton_6);
        TextView boton7 = findViewById(R.id.boton_7);
        TextView boton8 = findViewById(R.id.boton_8);
        TextView boton9 = findViewById(R.id.boton_9);
        TextView boton0 = findViewById(R.id.boton_0);
        TextView botonc = findViewById(R.id.boton_c);
        TextView botonpunto = findViewById(R.id.boton_coma);
        TextView botonpotencia = findViewById(R.id.boton_potencia);
        TextView botonporciento = findViewById(R.id.boton_porciento);
        TextView botondivicion = findViewById(R.id.boton_divicion);
        TextView botonborrar = findViewById(R.id.boton_borrar);
        TextView botonx = findViewById(R.id.boton_x);
        TextView botonmenos = findViewById(R.id.boton_menos);
        TextView botonmas = findViewById(R.id.boton_mas);
        TextView botonigual = findViewById(R.id.boton_igual);




        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("1");
            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("2");
            }
        });


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("3");
            }
        });


        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("4");
            }
        });


        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("5");
            }
        });


        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("6");
            }
        });


        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("7");
            }
        });


        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("8");
            }
        });


        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("9");
            }
        });

        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumeroAlTextView("0");
            }
        });

        botonpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punto==0){
                    agregarNumeroAlTextView(".");
                    punto=punto +1;
                }


            }
        });
        botonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                punto=0;
            }
        });

        botonmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperador('+');

            }
        });

        botonmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text1.getText().toString().equals("")) {
                    agregarNumeroAlTextView("-");
                } else if (text1.getText().toString().equals("-")) {
                    text1.setText("Error");
                } else {
                    guardarOperador('-');
                }
            }
        });

        botonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperador('*');

            }
        });

        botondivicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperador('/');
            }
        });

        botonpotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperador('^');
            }
        });


        botonigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operador=='+'||operador=='/'||operador=='*'||operador=='^'||operador=='-'){
                    String numeroActual = text1.getText().toString();
                    float numero2 = Float.parseFloat(numeroActual);
                    float resultado = 0;
                    switch (operador) {
                        case '+':
                            resultado = numero1 + numero2;
                            break;
                        case '-':
                            resultado = numero1 - numero2;
                            break;
                        case '*':
                            resultado = numero1 * numero2;
                            break;
                        case '/':
                            if (numero2 != 0) {
                                resultado = numero1 / numero2;
                            } else {
                                // Manejo de división por cero
                                resultado = 0; // O alguna otra acción
                            }
                            break;
                        case '^':
                            resultado = (float) Math.pow(numero1, numero2);
                            break;
                        default:
                            text1.setText("Error");
                            break;


                    }
                    text1.setText(String.valueOf(resultado));
                }
                else{
                    text1.setText("Error");
                }
                operador = '\0';
                numero1 = 0;
                text2.setText("");
                text3.setText("");
            }
        });

        botonporciento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punto=0;
                text2.setText("");
                text3.setText("");
                if (text1.getText().toString()=="Error"){
                    text1.setText("");
                }
                else {
                    if (text1.getText().equals("")){
                        text1.setText("Error");
                    }
                    else {
                        String numeroActual = text1.getText().toString();
                        float numero = Float.parseFloat(numeroActual);
                        float resultado = numero / 100;
                        text1.setText(String.valueOf(resultado));
                    }
                }


            }
        });

        botonborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punto=0;
                if (text1.getText().toString()=="Error"){
                    text1.setText("");
                }
                else {
                    String numeroActual = text1.getText().toString();
                    if (!numeroActual.isEmpty()) {
                        String nuevoNumero = numeroActual.substring(0, numeroActual.length() - 1);
                        text1.setText(nuevoNumero);
                    }
                }


            }
        });

    }

    private void agregarNumeroAlTextView(String numero) {
        if (text1.getText().toString()=="Error"){
            text1.setText("");
            String numeroActual = text1.getText().toString();
            String nuevoNumero = numeroActual + numero;
            text1.setText(nuevoNumero);
        }
        else {
            String numeroActual = text1.getText().toString();
            String nuevoNumero = numeroActual + numero;
            text1.setText(nuevoNumero);
        }
    }

    // Método para guardar el operador y el número1
    private void guardarOperador(char oper) {
        punto=0;
        if (text1.getText().toString()=="Error"){
            text1.setText("");
        }
        else {
            if (text1.getText().equals("")){
                text1.setText("Error");
            }
            else {
                String numeroActual = text1.getText().toString();
                numero1 = Float.parseFloat(numeroActual);
                text2.setText(numeroActual);
                text3.setText(" " + oper);
                text1.setText("");
                operador = oper;
                punto = 0;
            }
        }
    }
}