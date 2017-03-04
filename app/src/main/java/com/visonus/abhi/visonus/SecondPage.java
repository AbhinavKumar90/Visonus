package com.visonus.abhi.visonus;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Abhi on 3/3/2017.
 */

public class SecondPage extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener{

    EditText input;
    Button button_speak;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        input = (EditText) findViewById(R.id.input);
        button_speak = (Button) findViewById(R.id.button_speak);

        button_speak.setOnClickListener(this);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            Locale locale = tts.getLanguage();
            int result = tts.setLanguage(locale);
            if(result == TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","This language is not supported");
            }
            else{
                //Do nothing
            }
        }
        else{
            Log.e("TTS","initialization failed");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_speak:
                String text = input.getText().toString();
                if(text.isEmpty()){
                    Toast.makeText(SecondPage.this, "Text is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null );
                }
                break;
        }
    }
}
