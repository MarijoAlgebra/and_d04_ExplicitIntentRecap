package org.bubulescu.explicitintentrecap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_IME = "ime";
    public static final String KEY_PREZIME = "prezime";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_LOZINKA = "lozinka";

    private EditText etIme, etPrezime, etEmail, etLozinka;
    private Button bRegister, bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();

    }

    private void initWidgets() {
        etIme = findViewById(R.id.etIme);
        etPrezime = findViewById(R.id.etPrezime);
        etEmail = findViewById(R.id.etEmail);
        etLozinka = findViewById(R.id.etLozinka);
        bRegister = findViewById(R.id.bRegiter);
        bCancel = findViewById(R.id.bCancel);
    }

    private void setupListeners() {
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ime = etIme.getText().toString();
                String prezime = etPrezime.getText().toString();
                String email = etEmail.getText().toString();
                String lozinka = etLozinka.getText().toString();

                Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                intent.putExtra(KEY_IME, ime);
                intent.putExtra(KEY_PREZIME, prezime);
                intent.putExtra(KEY_EMAIL, email);
                intent.putExtra(KEY_LOZINKA, lozinka);
                startActivity(intent);

            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etIme.setText("");
                etPrezime.setText("");
                etEmail.setText("");
                etLozinka.setText("");
                etIme.requestFocus();
                etIme.setError("Obavezan unos!");
            }
        });
    }
}
