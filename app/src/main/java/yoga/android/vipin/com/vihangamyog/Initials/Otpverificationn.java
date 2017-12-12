package yoga.android.vipin.com.vihangamyog.Initials;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import yoga.android.vipin.com.vihangamyog.R;

public class Otpverificationn extends AppCompatActivity {
    String verificationId;
    String code;
    FirebaseAuth mAuth;
    String TAG="tag";
    Button bb,resendbb;
    EditText ee;
    SharedPreferences sp;
    TextView ttv;
    public int seconds = 60;
    String phonee;
    String phoneNumber;
    PhoneAuthProvider.ForceResendingToken fff;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverificationn);
       mAuth = FirebaseAuth.getInstance();
        bb=(Button)findViewById(R.id.verifyy);
        resendbb=(Button)findViewById(R.id.button3);
        ee=(EditText)findViewById(R.id.editText7);
        ttv=(TextView)findViewById(R.id.textView3);
       sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        phoneNumber=sp.getString("Number",null);
        Toast.makeText(this,"No. is"+phoneNumber,Toast.LENGTH_LONG).show();
        //Declare the timer
        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void run() {

                        ttv.setText(getString(R.string.reee)+" "+String.valueOf(seconds) +" Seconds");
                        ttv.setTextColor(R.color.colortext);
                        seconds -= 1;

                        if(seconds == 0 ||seconds<0)
                        {
                            ttv.setText("Re-Send the code.Press the Button Below");
                            resendbb.setEnabled(true);
                            resendbb.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    resendVerificationCode(phoneNumber,fff);
                                }
                            });
                        }



                    }

                });
            }

        }, 0, 1000);

    }
    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        // [START verify_with_code]
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = task.getResult().getUser();
                            String aaa=user.getDisplayName();
                            String bbb=user.getPhoneNumber();
                            sp.edit().putString("name",aaa).apply();
                            sp.edit().putString("phone",bbb).apply();
                            Log.d(TAG, aaa+bbb);
                            Intent ii=new Intent(getApplicationContext(),Homepagee.class);
                            startActivity(ii);
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(),"The Code entered is Invalid.Please Try again",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });


    }
    private void resendVerificationCode(String phoneeee, PhoneAuthProvider.ForceResendingToken token) {

    }

    public void veriff(View view){
        verificationId=sp.getString("verifi",null);
        code=ee.getText().toString();
        verifyPhoneNumberWithCode(verificationId,code);
    }
}
