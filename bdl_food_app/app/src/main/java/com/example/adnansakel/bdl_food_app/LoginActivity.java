package com.example.adnansakel.bdl_food_app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adnansakel.bdl_food_app.DataModel.AppConstants;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

/**
 * Created by Adnan Sakel on 3/29/2016.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private Button button_sign_in;
    private Button button_sign_up;

    private EditText editText_email;
    private EditText editText_password;

    private String email = "";
    private String password = "";

    Context context;

    Firebase loginref;

    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeComponent();
    }

    private void initializeComponent(){
        button_sign_in = (Button)findViewById(R.id.button_sign_in);
        button_sign_up = (Button)findViewById(R.id.button_sign_up);

        editText_email = (EditText)findViewById(R.id.edit_text_email);
        editText_password = (EditText)findViewById(R.id.edit_text_password);

        button_sign_in.setOnClickListener(this);
        button_sign_up.setOnClickListener(this);

        Firebase.setAndroidContext(this);
        loginref = new Firebase(AppConstants.FirebaseUri);

        context = getApplicationContext();



        /*Firebase ref = new Firebase("https://android-chat.firebaseio-demo.com/chat");
        Query queryRef = ref.orderByChild("author").equalTo("JavaUser6564");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // do some stuff once
                System.out.println("Query result:" + snapshot);
                int i = 1;
                for( DataSnapshot sn : snapshot.getChildren()){
                    System.out.println("Query result "+(i++)+ " :" + sn.getKey());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });*/


    }

    @Override
    public void onClick(View v) {
        if(v == button_sign_in){
            email = editText_email.getText().toString();
            password = editText_password.getText().toString();
            progress = ProgressDialog.show(this, null,
                    null, true);
            progress.setContentView(R.layout.progressdialogview);
            progress.setCancelable(true);
            loginref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    //System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                    AppConstants.UserID = authData.getUid();
                    progress.dismiss();
                    startActivity(new Intent(LoginActivity.this, NewsFeedActivity.class));
                    LoginActivity.this.finish();

                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    // there was an error
                }
            });
        }
        if(v == button_sign_up){
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

        }
    }
}
