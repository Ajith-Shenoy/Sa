package in.edu.reva.myapplication;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Firebase extends AppCompatActivity {
    private EditText inputName, inputEmail, inputUsn, inputContact, inputCollege, inputRegAmount, inputEventName;
    private Button SubmitForm;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextInputLayout inputLayoutName, inputLayoutEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        //get data from previous activity
        Intent intent=getIntent();
        String RegAmount=intent.getStringExtra("regAmount");
        String Ename=intent.getStringExtra("Ename");
        //data recieved
        inputName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        inputUsn = (EditText) findViewById(R.id.usn);
        inputEventName = (EditText) findViewById(R.id.EventName);
        inputEventName.setText(Ename);
        inputContact = (EditText) findViewById(R.id.phone);
        inputCollege = (EditText) findViewById(R.id.college);
        inputRegAmount = (EditText) findViewById(R.id.RegAmount);
        inputRegAmount.setText(RegAmount);
        SubmitForm = (Button) findViewById(R.id.RegButton);

        //Textinputlatout
        inputLayoutName = findViewById(R.id.til_name);
        inputLayoutEmail = findViewById(R.id.til_mail);
        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        mFirebaseInstance.getReference("app_title").setValue("Saviskara Registration Form");
        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                getSupportActionBar().setTitle(appTitle);
            }
            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });
        // Save the user
        SubmitForm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String usn=inputUsn.getText().toString();
                String eventName=inputEventName.getText().toString();
                String contact=inputContact.getText().toString();
                String college =inputCollege.getText().toString();
                String regamount=inputRegAmount.getText().toString();


                //Fields Empty

                if (name.equals("") || college.equals("") || regamount.equals("") || email.equals("") || usn.equals("") || eventName.equals("") || contact.equals("")) {
                    Toast.makeText(Firebase.this, "All Credentials are Mandatory", Toast.LENGTH_SHORT).show();
                }

                else{
                createUser(name,email,usn,contact,regamount,eventName,college);
                Toast.makeText(Firebase.this,"Thank You!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Firebase.this,MainActivity.class);
                startActivity(i);
                finish();
            }
            submitForm();



            }
        });
    }
    private void createUser(String name, String email,String usn,String pno,String regamount,String ename,String colName)
    {
        // TODO

        userId = mFirebaseDatabase.push().getKey();

        User user = new User(name,email,usn,pno,regamount,ename,colName);

        mFirebaseDatabase.child(userId).setValue(user);

        addUserChangeListener();

    }
    private void addUserChangeListener()
    {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                User user = dataSnapshot.getValue(User.class);

                // Check for null
                if (user == null)
                {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                // clear edit text
                inputEmail.setText("");
                inputName.setText("");
                inputCollege.setText("");
                inputContact.setText("");
                inputRegAmount.setText("");
                inputUsn.setText("");
                inputEventName.setText("");
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });}




        /**
         * Validating form
         */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }


    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.name:
                    validateName();
                    break;
                case R.id.email:
                    validateEmail();
                    break;
            }
        }

    }
}
