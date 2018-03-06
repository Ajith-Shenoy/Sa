package in.edu.reva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        inputName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        inputUsn = (EditText) findViewById(R.id.usn);
        inputEventName = (EditText) findViewById(R.id.EventName);
        inputContact = (EditText) findViewById(R.id.phone);
        inputCollege = (EditText) findViewById(R.id.college);
        inputRegAmount = (EditText) findViewById(R.id.RegAmount);
        SubmitForm = (Button) findViewById(R.id.RegButton);
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
                createUser(name,email,usn,contact,regamount,eventName,college);
                Toast.makeText(Firebase.this,"Thank You!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Firebase.this,MainActivity.class);
                startActivity(i);
                finish();

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
        });
    }
}
