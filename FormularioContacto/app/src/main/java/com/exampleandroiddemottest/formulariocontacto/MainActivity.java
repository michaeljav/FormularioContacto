package com.exampleandroiddemottest.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText edNombre;
    private DatePicker dpFechaDeNacimiento;
    private EditText edTelefono;
    private EditText etEmail;
    private EditText etDescripcionContacto;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.edNombre);
        dpFechaDeNacimiento = findViewById(R.id.dpFechaDeNacimiento);
        edTelefono = findViewById(R.id.edTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcionContacto = findViewById(R.id.etDescripcionContacto);
        btnSiguiente = findViewById(R.id.btnSeguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              SiguientePantalla(view);
            }
        });

     Bundle bundle = getIntent().getExtras();
        String nombre ="";
 if (bundle != null){
       nombre = bundle.getString(getResources().getString(R.string.pNombre));
       String fechaNaci = bundle.getString(getResources().getString(R.string.pFechaDeNacimiento));
       String[] fechaArray =fechaNaci.split("/");
       String tel = bundle.getString(getResources().getString(R.string.pTelefono));
       String email = bundle.getString(getResources().getString(R.string.pEmail));
       String descrip = bundle.getString(getResources().getString(R.string.pDescripcionContacto));

       edNombre.setText(nombre);
       dpFechaDeNacimiento.updateDate(Integer.parseInt(fechaArray[2].toString()),
                                        Integer.parseInt(fechaArray[1].toString())-1,
                                        Integer.parseInt(fechaArray[0].toString()));
        edTelefono.setText(tel);
        etEmail.setText(email);
        etDescripcionContacto.setText(descrip);
 }




    }

    public void SiguientePantalla(View view){
     String fechaNacimiento = dpFechaDeNacimiento.getDayOfMonth()+"/"+(dpFechaDeNacimiento.getMonth()+1)+"/"+dpFechaDeNacimiento.getYear();
      Intent intent = new Intent(MainActivity.this,DetallesContacto.class);
     intent.putExtra(getResources().getString(R.string.pNombre),edNombre.getText().toString());
    intent.putExtra(getResources().getString(R.string.pFechaDeNacimiento),fechaNacimiento);
      intent.putExtra(getResources().getString(R.string.pTelefono),edTelefono.getText().toString());
      intent.putExtra(getResources().getString(R.string.pEmail),etEmail.getText().toString());
      intent.putExtra(getResources().getString(R.string.pDescripcionContacto),etDescripcionContacto.getText().toString());
      startActivity(intent);
      finish();

    }


}
