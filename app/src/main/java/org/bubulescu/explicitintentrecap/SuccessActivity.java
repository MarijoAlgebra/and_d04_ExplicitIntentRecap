package org.bubulescu.explicitintentrecap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    private TextView tvSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        initWidgets();
        handleIntent();

    }

    private void initWidgets() {
        tvSuccess = findViewById(R.id.tvSuccess);
    }

    private void handleIntent() {
        Intent intent = getIntent();

        String ime = intent.getStringExtra(MainActivity.KEY_IME);
        String prezime = intent.getStringExtra(MainActivity.KEY_PREZIME);
        String email = intent.getStringExtra(MainActivity.KEY_EMAIL);
        String lozinka = intent.getStringExtra(MainActivity.KEY_LOZINKA);

        String result = "Dobrodošao " + ime + " " + prezime + ".\n"
                        + "Vaša registracija je uspješna.\n\n"
                        + "email: " + email + "\n"
                        + "lozinka: " + lozinka
                ;

        tvSuccess.setText(result);

    }

}
