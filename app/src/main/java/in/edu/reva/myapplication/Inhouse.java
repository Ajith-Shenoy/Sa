package in.edu.reva.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inhouse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inhouse);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
    }
    public void gotoRecreational (View v)
    {
        Intent i = new Intent(this,Recreational.class);
        startActivity(i);
    }
    public void gotoCultural (View v)
    {
        Intent i = new Intent(this,CulturalMain.class);
        startActivity(i);
    }
    public void gotoTechnical (View v)
    {
        Intent i = new Intent(this,TechMain.class);
        startActivity(i);
    }

}
