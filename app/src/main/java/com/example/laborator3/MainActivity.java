package com.example.laborator3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.buttonChangeText);
        TextView textView = findViewById(R.id.textResult);
        Switch switchConfirm = findViewById(R.id.switchConfirm);

        button.setEnabled(false);

        switchConfirm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            button.setEnabled(isChecked);
        });

        button.setOnClickListener(view -> {
            String inputText = editText.getText().toString();

            if (inputText.trim().isEmpty()) {
                editText.setError(getString(R.string.empty_text_error));
                return;
            }

            editText.setError(null);
            textView.setText(inputText);
            Toast.makeText(
                    MainActivity.this,
                    R.string.toast_text_changed,
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}

