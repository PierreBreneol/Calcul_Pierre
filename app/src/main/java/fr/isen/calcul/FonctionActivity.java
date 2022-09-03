package fr.isen.calcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FonctionActivity extends AppCompatActivity {

    public static final String RESULT_FONCTION = "RESULT_FONCTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fonction);
    }

    public void logClick (View view){
        Intent intentMain = getIntent();
        double  numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);
        double result = Math.log(numero_A);
        intentMain.putExtra(RESULT_FONCTION, result);
        setResult(RESULT_OK, intentMain);
        finish();

    }

    public void log10Click (View view){
        Intent intentMain = getIntent();
        double numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);
        double result = Math.log10(numero_A);
        Intent intent = new Intent();
        intent.putExtra(RESULT_FONCTION, result);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void expClick (View view){
        Intent intentMain = getIntent();
        double numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);
        double result = Math.log(numero_A);
        Intent intent = new Intent();
        intent.putExtra(RESULT_FONCTION, result);
        setResult(RESULT_OK, intent);
        finish();

    }
}
