package fr.isen.calcul;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixBActivity extends AppCompatActivity {
    public static final String NUMERO_B = "NUMERO_B";

    private EditText mNumeroB;
    private Button mButtonValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choixb);

        mNumeroB = findViewById(R.id.editText1_choix_b);
        mButtonValidation = findViewById(R.id.button1_choix_b);
        mButtonValidation.setEnabled(false);//le bouton n'est pas cliquable si un nombre n'est pas entré dans l'EditText
        mNumeroB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mButtonValidation.setEnabled(!editable.toString().isEmpty());//on active le bouton si le champ n'est pas vide
            }
        });
    }
        public void validationClick(View view){

            Intent intent = new Intent();//on créé un nouvel intent
            intent.putExtra(NUMERO_B, Double.parseDouble(mNumeroB.getText().toString()));//on met numéroB dans l'intent
            setResult(RESULT_OK, intent);//on met le result_code à "RESULT_OK"
            finish(); //on envoie le résultat à l'activité 2
        }

    }