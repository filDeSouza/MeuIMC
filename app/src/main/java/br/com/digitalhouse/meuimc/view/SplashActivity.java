package br.com.digitalhouse.meuimc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.meuimc.R;

public class SplashActivity extends AppCompatActivity {

    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        },2000);

    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, CadastroActivity.class));
    }
}
