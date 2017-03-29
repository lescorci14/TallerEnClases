package com.example.android.tallerenclases;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class PrincipalActivity extends AppCompatActivity {

    private EditText cajaCantidad;
    private Spinner comboMaterial;
    private Spinner comboDije;
    private Spinner comboTipo;
    private RadioButton r1, r2;
    private Intent i;
    private Bundle b;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private String[] opc1;
    private String[] opc2;
    private String[] opc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaCantidad = (EditText)findViewById(R.id.txtCantidad);
        comboMaterial = (Spinner)findViewById(R.id.cmbMaterial);
        comboDije = (Spinner)findViewById(R.id.cmbDije);
        comboTipo = (Spinner)findViewById(R.id.cmbTipo);

        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);

        i = new Intent(this,enviado.class);
        b = new Bundle();

        opc1 = this.getResources().getStringArray(R.array.material);
        opc2 = this.getResources().getStringArray(R.array.dije);
        opc3 = this.getResources().getStringArray(R.array.tipo);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc3);

        comboMaterial.setAdapter(adapter1);
        comboDije.setAdapter(adapter2);
        comboTipo.setAdapter(adapter3);

    }

    public void enviar(View v){
        String cant, material, dije, tipo, moneda="", res="";
        int cant2=0, valor=0, valorf=0;

        if(validar()){
            cant = cajaCantidad.getText().toString();
            cant2 = Integer.parseInt(cant);

            material = comboMaterial.getSelectedItem().toString();
            dije = comboDije.getSelectedItem().toString();
            tipo = comboTipo.getSelectedItem().toString();

            if(r1.isChecked()) moneda = getResources().getString(R.string.dolar);
            if(r2.isChecked()) moneda = getResources().getString(R.string.pesos);

            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.oro))){
                valor = 100;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.oro_rosado))){
                valor = 100;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.plata))){
                valor = 80;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.niquel))){
                valor = 70;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.oro))){
                valor = 120;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.oro_rosado))){
                valor = 120;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.plata))){
                valor = 100;
            }
            if(material.equals(getResources().getString(R.string.cuero)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.niquel))){
                valor = 90;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.oro))){
                valor = 90;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.oro_rosado))){
                valor = 90;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.plata))){
                valor = 70;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.martillo)) && tipo.equals(getResources().getString(R.string.niquel))){
                valor = 50;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.oro))){
                valor = 110;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.oro_rosado))){
                valor = 110;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.plata))){
                valor = 90;
            }
            if(material.equals(getResources().getString(R.string.cuerda)) && dije.equals(getResources().getString(R.string.ancla)) && tipo.equals(getResources().getString(R.string.niquel))){
                valor = 80;
            }

            if(moneda.equals(getResources().getString(R.string.dolar))){
                valorf = valor*cant2;
            }
            if(moneda.equals(getResources().getString(R.string.pesos))){
                valorf = valor*cant2*3200;
            }

            res = res+valorf;

            b.putString("Resultado", res);
            b.putString("Moneda", moneda);

            i.putExtras(b);

            startActivity(i);
        }
    }

    public boolean validar(){
        if(cajaCantidad.getText().toString().isEmpty()){
            cajaCantidad.setError(getResources().getString(R.string.error1));
            return false;
        }

        return true;
    }
}
