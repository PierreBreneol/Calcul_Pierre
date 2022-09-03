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

    public void additionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, ChoixBActivity.class);
        startActivityForResult(fonctionActivity, PLUS_REQUEST_CODE);
    }

    public void soustractionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, ChoixBActivity.class);
        startActivityForResult(fonctionActivity, MOINS_REQUEST_CODE);
    }

    public void multiplicationClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, ChoixBActivity.class);
        startActivityForResult(fonctionActivity, MULTIPLE_REQUEST_CODE);
    }

    public void divisionClick (View view){
        Intent fonctionActivity = new Intent(OperationActivity.this, ChoixBActivity.class);
        startActivityForResult(fonctionActivity, DIVISE_REQUEST_CODE);
    }

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
        Intent intent = new Intent();
        intent.putExtra(RESULT_CALCUL, value);
        setResult(RESULT_OK, intent);
        finish();
    }

















}
