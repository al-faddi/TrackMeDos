package com.projet.al_faddi.track;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by al-faddi on 24/08/2016.
 */
public class connexionActivity extends Activity {
    String EXTRA_LOGIN = "user_login";
    String EXTRA_PASSWORD = "user_password";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_main);
    //
        //les service code on demarre
            startService(new Intent(connexionActivity.this, MonService.class));
       //fin


        //pour les champs
        final EditText login = (EditText) findViewById(R.id.user_email);
        final EditText pass = (EditText) findViewById(R.id.user_password);

        //code bouton pour quitter
        Button con=(Button) findViewById(R.id.connect);
        con.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                //Si un des deux champs est vide email non correcte
                String loginTxt = login.getText().toString();
                String PassTxt = pass.getText().toString();
                // On déclare le pattern que l’on doit vérifier
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                // On déclare un matcher, qui comparera le pattern avec la string passée en argument
                Matcher m = p.matcher(loginTxt);

                if (!m.matches()) {
                    Toast.makeText(connexionActivity.this, R.string.erreur_mail, Toast.LENGTH_SHORT).show();
                    return;
                }
                //champ vide
                if (loginTxt.equals("") || PassTxt.equals("")) {
                    Toast.makeText(connexionActivity.this, R.string.email_password_vide, Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent= new Intent(connexionActivity.this,MainActivity.class);
                intent.putExtra(EXTRA_LOGIN, login.getText().toString());
                intent.putExtra(EXTRA_PASSWORD, pass.getText().toString());
                startActivity(intent);
            }
        });
    }
}
