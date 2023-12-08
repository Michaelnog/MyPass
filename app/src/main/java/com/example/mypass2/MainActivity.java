    package com.example.mypass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypass2.Activity.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

    public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btn_logout;
    private Button bnt_gerar;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btn_logout = findViewById(R.id.bnt_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
        public void Gerar(View view){

            TextView textResultado;

            textResultado = findViewById(R.id.textResultado);

            int numero = new Random().nextInt();
            textResultado.setText("Passoword:"+ numero);
        }
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
            if (currentuser==null){
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        }
    }
