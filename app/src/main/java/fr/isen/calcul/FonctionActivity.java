package fr.isen.calcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        double  numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);//on récupère numeroA reçu de MainActivity
        double result = Math.log(numero_A);//calcul du log
        intentMain.putExtra(RESULT_FONCTION, result);//on le met dans l'intent
        setResult(RESULT_OK, intentMain);//on met le resultCode à "RESULT_OK"
        finish();

    }

    public void log10Click (View view){
        Intent intentMain = getIntent();
        double numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);//on récupère numeroA reçu de MainActivity
        double result = Math.log10(numero_A);
        intentMain.putExtra(RESULT_FONCTION, result);//on le met dans l'intent
        setResult(RESULT_OK, intentMain);//on met le resultCode à "RESULT_OK"
        finish();

    }

    public void expClick (View view){
        Intent intentMain = getIntent();
        double numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A, 0);//on récupère numeroA reçu de MainActivity
        double result = Math.log(numero_A);
        intentMain.putExtra(RESULT_FONCTION, result);//on le met dans l'intent
        setResult(RESULT_OK, intentMain);//on met le resultCode à "RESULT_OK"
        finish();

    }
}
