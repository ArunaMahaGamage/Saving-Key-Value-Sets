package com.example.savingkey_valuesets;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_show;
    EditText et_add;
    Button btn_save;
    Button btn_show;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        uiDeclare();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharesPreferanceSave();
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharesPreferanceShow();
            }
        });

    }

    private void uiDeclare() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        et_add = (EditText) findViewById(R.id.et_add);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_show = (Button) findViewById(R.id.btn_show);
    }

    public void sharesPreferanceSave() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_high_score), et_add.getText().toString());
        editor.commit();
    }

    public void sharesPreferanceShow() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.saved_high_score);
        String highScore = sharedPref.getString(getString(R.string.saved_high_score), defaultValue);

        tv_show.setText(highScore);
    }
}
