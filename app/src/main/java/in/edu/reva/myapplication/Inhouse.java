package in.edu.reva.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Inhouse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inhouse);
        getSupportActionBar().setTitle("In-house Event Categories");
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.darkStatus));
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
    public void webbutton2(View v)
    {
        Intent intent = new Intent(Inhouse.this,Web_Visit.class);
        startActivity(intent);
    }

}
