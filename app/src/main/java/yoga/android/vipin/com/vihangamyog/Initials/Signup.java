package yoga.android.vipin.com.vihangamyog.Initials;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


import java.util.concurrent.TimeUnit;

import yoga.android.vipin.com.vihangamyog.R;


public class Signup extends AppCompatActivity {
    private PhoneAuthProvider mAuth;
    EditText email1, name1, pass3, repasse4;
    Button sign1;
    String TAG = "stri";
    String num, email, namee, passs;
    String mVerificationId;
    PhoneAuthProvider.ForceResendingToken mResendToken;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = PhoneAuthProvider.getInstance();
        email1 = (EditText) findViewById(R.id.editText6);
        name1 = (EditText) findViewById(R.id.editText3);
        pass3 = (EditText) findViewById(R.id.editText4);
        repasse4 = (EditText) findViewById(R.id.editText5);
        sign1 = (Button) findViewById(R.id.button2);
sp=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        sign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa();

            }
        });

    }


    public void aaa() {

        num = name1.getText().toString();
        email = email1.getText().toString();
        namee = pass3.getText().toString();
        passs = repasse4.getText().toString();
        sp.edit().putString("password",passs).apply();
        if (email.matches("")) {

            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            email1.setError("Please Enter your Name");
        }

        if (passs.matches("")) {

            Toast.makeText(this, "You did not enter a password", Toast.LENGTH_SHORT).show();
            repasse4.setError("Set a password");
        }

        if (namee.matches("")) {

            Toast.makeText(this, "You did not enter a Mobile number", Toast.LENGTH_SHORT).show();
            pass3.setError("Enter Mobile number");
        } else {
            mAuth.verifyPhoneNumber(namee, 120, TimeUnit.SECONDS, this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(PhoneAuthCredential credential) {
                    Log.d(TAG, "onVerificationCompleted:" + credential);


                }

                @Override
                public void onVerificationFailed(FirebaseException e) {

                    Log.w(TAG, "onVerificationFailed", e);

                    if (e instanceof FirebaseAuthInvalidCredentialsException) {
                      pass3.setError("Invalid phone number.");
                    } else if (e instanceof FirebaseTooManyRequestsException) {

                    }


                }

                @Override
                public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {

                    Log.d(TAG, "onCodeSent:" + verificationId);
                    mVerificationId = verificationId;
                    mResendToken  = token;
                    Intent i = new Intent(Signup.this, Otpverificationn.class);
                    startActivity(i);
                    sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    sp.edit().putString("verifi",verificationId).apply();
                }
            });

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
