package com.example.android.tallerenclases;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class enviado extends AppCompatActivity {

    private TextView enviado;
    private Bundle b;
    private String aux, total, moneda;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviado);

        enviado = (TextView)findViewById(R.id.txtResultado);
        b = getIntent().getExtras();
        total = b.getString("Resultado");
        moneda = b.getString("Moneda");
        res = this.getResources();

        aux = getResources().getString(R.string.parte1)+" "+ total+" "+moneda;

        enviado.setText(aux);
    }
}
