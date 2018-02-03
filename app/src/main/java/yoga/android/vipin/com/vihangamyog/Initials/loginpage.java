package yoga.android.vipin.com.vihangamyog.Initials;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import yoga.android.vipin.com.vihangamyog.R;

public class loginpage extends AppCompatActivity {

    TextView tv;
    EditText mob,namee;
    Button bbb;
  FirebaseAuth mAuthh;
    private PhoneAuthProvider mAuth;
  String TAG="asd";
  SharedPreferences sp;
  String ss,codee;
    String mVerificationId;
  String mobb;
    PhoneAuthProvider.ForceResendingToken mResendToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        //tv=(TextView)findViewById(R.id.textView);
        mob=(EditText)findViewById(R.id.editText2);
        namee=findViewById(R.id.editText);
        bbb=(Button)findViewById(R.id.button);
        mAuthh=FirebaseAuth.getInstance();
mAuth=PhoneAuthProvider.getInstance();
        if (mAuthh.getCurrentUser()!=null){
          Intent i=new Intent(this,Homepagee.class);
          startActivity(i);

        }
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
          bbb.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                     ss=mob.getText().toString();
                 if (ss.matches("")) {

                      Toast.makeText(getBaseContext(), "You did not enter a mobile number", Toast.LENGTH_SHORT).show();
                      mob.setError("Please Enter the Number");
                  }


                  else {
                     loginthroughotp();
                  }

              }
          });

    }

public void loginthroughotp(){

        mAuth.verifyPhoneNumber(ss, 120, TimeUnit.SECONDS, this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {
                        Log.d(TAG, "onVerificationCompleted:" + credential);


                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {

                        Log.w(TAG, "onVerificationFailed", e);
                        if (e instanceof FirebaseAuthInvalidCredentialsException) {
                            mob.setError("Invalid phone number.");
                        } else if (e instanceof FirebaseTooManyRequestsException) {

                        }


                    }

                    @Override
                    public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {

                        Log.d(TAG, "onCodeSent:" + verificationId);
                        mVerificationId = verificationId;
                        mResendToken  = token;
                        Intent i = new Intent(loginpage.this, Otpverificationn.class);
                        startActivity(i);
                        sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                        sp.edit().putString("verifi",verificationId).apply();
                    }
                });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }


}
