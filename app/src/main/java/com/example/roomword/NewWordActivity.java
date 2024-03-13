package com.example.roomword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText etWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        etWord = findViewById(R.id.etWord);

        final Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();

                if (TextUtils.isEmpty(etWord.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = etWord.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY, word);

                    setResult(RESULT_OK, replyIntent);
                }

                finish();
            }
        });
    }
}