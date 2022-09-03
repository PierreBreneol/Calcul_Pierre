package fr.isen.calcul;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final int OPERATION_ACTIVITY_REQUEST_CODE = 100;
    private static final int EQUATION_ACTIVITY_REQUEST_CODE = 200;
    private static final int FONCTION_ACTIVITY_REQUEST_CODE = 300;

    private EditText mNumeroA;
    private Button mButtonOperation;
    private Button mButtonEquation;
    private Button mButtonFonction;

    public static final String NUMERO_A = "NUMERO_A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumeroA =findViewById(R.id.editText);
        mButtonOperation = findViewById(R.id.button);
        mButtonEquation = findViewById(R.id.button2);
        mButtonFonction = findViewById(R.id.button3);

        mButtonOperation.setEnabled(false);
        mButtonEquation.setEnabled(false);
        mButtonFonction.setEnabled(false);

        mNumeroA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mButtonOperation.setEnabled(!editable.toString().isEmpty());
                mButtonFonction.setEnabled(!editable.toString().isEmpty());
                mButtonEquation.setEnabled(!editable.toString().isEmpty());
            }
        });
    }

    public void operationClick(View view){
        Intent operationActivity = new Intent(MainActivity.this, fr.isen.calcul.OperationActivity.class);
        operationActivity.putExtra(NUMERO_A, Double.parseDouble(mNumeroA.getText().toString()));
        startActivityForResult(operationActivity, OPERATION_ACTIVITY_REQUEST_CODE);
    }

    public void equationClick(View view){
        Intent equationActivity = new Intent(MainActivity.this, fr.isen.calcul.EquationActivity.class);
        startActivityForResult(equationActivity, EQUATION_ACTIVITY_REQUEST_CODE);
    }

    public void fonctionClick(View view){
        Intent fonctionActivity = new Intent(MainActivity.this, fr.isen.calcul.FonctionActivity.class);
        fonctionActivity.putExtra(NUMERO_A, Double.parseDouble(mNumeroA.getText().toString()));
        startActivityForResult(fonctionActivity, FONCTION_ACTIVITY_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RESULT_OK == resultCode) {
            switch (requestCode) {

                case OPERATION_ACTIVITY_REQUEST_CODE:
                    double result = data.getDoubleExtra(OperationActivity.RESULT_CALCUL, -1);
                    mNumeroA.setText(String.valueOf(result));
                    break;

                case EQUATION_ACTIVITY_REQUEST_CODE:
                    String equation = data.getStringExtra(EquationActivity.RESULT_EQUATION);

                    switch (equation) {
                        case "racine":
                            double racine = Math.sqrt(parseInt(mNumeroA.getText().toString()));
                            mNumeroA.setText(String.valueOf(racine));
                            break;
                        case "puissance2":
                            double pow2 = Math.pow(Double.parseDouble(mNumeroA.getText().toString()), 2);
                            mNumeroA.setText(String.valueOf(pow2));
                            break;
                        case "puissance3":
                            double pow3 = Math.pow(Double.parseDouble(mNumeroA.getText().toString()), 3);
                            mNumeroA.setText(String.valueOf(pow3));
                            break;
                        default:
                            System.out.println("error case type equation");
                    }
                    break;

                case FONCTION_ACTIVITY_REQUEST_CODE:

                    double fonction = data.getDoubleExtra(FonctionActivity.RESULT_FONCTION, -2);
                    mNumeroA.setText(String.valueOf(fonction));
                    break;

                default:
                    System.out.println("error request");
            }
        } else System.out.println("error");
    }
}