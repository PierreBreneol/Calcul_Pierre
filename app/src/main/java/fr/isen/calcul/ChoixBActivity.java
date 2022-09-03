package fr.isen.calcul;

import android.annotation.SuppressLint;
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
        mButtonValidation.setEnabled(false);
        mNumeroB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mButtonValidation.setEnabled(!editable.toString().isEmpty());
            }
        });
    }
        public void validationClick(View view){

            Intent intent = new Intent();
            intent.putExtra(NUMERO_B, Double.parseDouble(mNumeroB.getText().toString()));
            setResult(RESULT_OK, intent);
            finish();
        }

    }