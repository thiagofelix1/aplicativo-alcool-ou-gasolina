package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool=findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina= findViewById(R.id.editPrecoGasolina);
        textResult=findViewById(R.id.textResult);

    }
    public void calcularPreco (View view) {
        //recuperar os valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();


        // validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
        } else {
            textResult.setText("preencha os preços primeiro");
        }
    }


        public void calcularMelhorPreco (String pAlcool, String pGasolina){
            //converter valores de string para números
            Double precoAlcool = Double.parseDouble(pAlcool);
            Double precoGasolina = Double.parseDouble(pGasolina);
            Double resultado = precoAlcool / precoGasolina;
            if (resultado >= 0.7) {
                textResult.setText("melhor utilizar gasolina");
            } else {
                textResult.setText("melhor utilizar Álcool");
            }
        }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}
