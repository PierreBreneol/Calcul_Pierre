package fr.isen.calcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EquationActivity extends AppCompatActivity {

    public static final String RESULT_EQUATION ="RESULT_EQUATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equation);
    }

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
