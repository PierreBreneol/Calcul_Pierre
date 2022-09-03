package fr.isen.calcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class EquationActivity extends AppCompatActivity {

    public static final String RESULT_EQUATION ="RESULT_EQUATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equation);
    }

// selon le bouton sur lequel on clique, on mettra la valeur de "RESULT_EQUATION" à
// "racine", "puissance2" ou "puissance3" selon le bouton sur lequel on appuie"

// ensuite on initialise le resultCode sur RESULT_OK
// et on envoie le resultat de l'activité

    public void racineClick (View view){
        Intent intent = new Intent();
        intent.putExtra(RESULT_EQUATION, "racine");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void puissance2Click (View view){
        Intent intent = new Intent();
        intent.putExtra(RESULT_EQUATION, "puissance2");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void puissance3Click (View view){
        Intent intent = new Intent();
        intent.putExtra(RESULT_EQUATION, "puissance3");
        setResult(RESULT_OK, intent);
        finish();

    }


}
