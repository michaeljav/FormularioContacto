package com.exampleandroiddemottest.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DetallesContacto extends AppCompatActivity {


    private TextView edNombre;
    private TextView dpFechaDeNacimiento;
    private TextView edTelefono;
    private TextView etEmail;
    private TextView etDescripcionContacto;
    private Button btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);

        edNombre            = findViewById(R.id.tvNombre);
       dpFechaDeNacimiento = findViewById(R.id.tvFechaParametro);
        edTelefono          = findViewById(R.id.tvTelefonoParametro);
        etEmail              = findViewById(R.id.tvEmailParametro);
        etDescripcionContacto = findViewById(R.id.tvDescripcionParametro);
        btnEditar             = findViewById(R.id.btnEditarDatos);

        Bundle bundle = getIntent().getExtras();

       String nombre = bundle.getString(getResources().getString(R.string.pNombre));
       String fechaNaci = bundle.getString(getResources().getString(R.string.pFechaDeNacimiento));
        String tel = bundle.getString(getResources().getString(R.string.pTelefono));
        String email = bundle.getString(getResources().getString(R.string.pEmail));
        String descrip = bundle.getString(getResources().getString(R.string.pDescripcionContacto));

     edNombre.setText(nombre);
      dpFechaDeNacimiento.setText(fechaNaci);
      edTelefono.setText(tel);
      etEmail.setText(email);
      etDescripcionContacto.setText(descrip);

      btnEditar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              actvityMainAgain();
          }
      });
    }


    public void actvityMainAgain(){
        Intent intent = new Intent(DetallesContacto.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pNombre),edNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pFechaDeNacimiento),dpFechaDeNacimiento.getText());
        intent.putExtra(getResources().getString(R.string.pTelefono),edTelefono.getText());
        intent.putExtra(getResources().getString(R.string.pEmail),etEmail.getText());
        intent.putExtra(getResources().getString(R.string.pDescripcionContacto),etDescripcionContacto.getText());
        startActivity(intent);
        finish();
    }
}
