package fr.isen.calcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OperationActivity extends AppCompatActivity {

    public static final String RESULT_CALCUL= "RESULT_CALCUL";

    private static final int PLUS_REQUEST_CODE = 1;
    private static final int MOINS_REQUEST_CODE = 2;
    private static final int MULTIPLE_REQUEST_CODE = 3;
    private static final int DIVISE_REQUEST_CODE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RESULT_OK == resultCode) {
            Intent intentMain = getIntent();
            double numero_A = intentMain.getDoubleExtra(MainActivity.NUMERO_A,0);
            double numero_B = data.getDoubleExtra(ChoixBActivity.NUMERO_B,1);

            switch (requestCode){
                case PLUS_REQUEST_CODE:
                    addition(numero_A,numero_B);
                    break;
                case MOINS_REQUEST_CODE:
                    substraction(numero_A,numero_B);
                    break;
                case MULTIPLE_REQUEST_CODE:
                    multiplication(numero_A,numero_B);
                    break;
                case DIVISE_REQUEST_CODE:
                    division(numero_A,numero_B);
                    break;
            }
        }
    }

    //On lance ChoixBActivity avec le requestCode correspondant au bouton sur lequel on a cliqué
    public void additionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, fr.isen.calcul.ChoixBActivity.class);
        startActivityForResult(fonctionActivity, PLUS_REQUEST_CODE);
    }

    public void soustractionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, fr.isen.calcul.ChoixBActivity.class);
        startActivityForResult(fonctionActivity, MOINS_REQUEST_CODE);
    }

    public void multiplicationClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, fr.isen.calcul.ChoixBActivity.class);
        startActivityForResult(fonctionActivity, MULTIPLE_REQUEST_CODE);
    }

    public void divisionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, fr.isen.calcul.ChoixBActivity.class);
        startActivityForResult(fonctionActivity, DIVISE_REQUEST_CODE);
    }

    //on réalise le calcul souhaité puis on appelle la méthode "render" qui renvoit ce résultat à l'activité 1
    private void addition(double numberA, double numberB){
        double result = numberA + numberB;
        render(result);
    }

    private void substraction(double numberA, double numberB){
        double result = numberA - numberB;
        render(result);
    }

    private void multiplication(double numberA, double numberB){
        double result = numberA * numberB;
        render(result);
    }

    private void division(double numberA, double numberB){
        double result = numberA / numberB;
        render(result);
    }

    public void render(double value){
        Intent intent = new Intent(); //on créé un nouvel intent
        intent.putExtra(RESULT_CALCUL, value); //on met le résultat dans l'intent
        setResult(RESULT_OK, intent); //on initialise
        finish(); //on envoie le résultat à MainActivity
    }

















}
