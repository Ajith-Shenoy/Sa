package in.edu.reva.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class Splashscreen extends AwesomeSplash
{
    @Override
    public void initSplash(ConfigSplash configSplash) {



        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.lightblue); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.saviskaraboutus); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FlipInX); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Title
        configSplash.setTitleSplash("Saviskara");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont("fonts/englishhindhi.ttf"); //provide string to your font l  ocated in assets/fonts/

    }

    @Override
    public void animationsFinished() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        //prevent back button from taking you back to the home screen
        finish();
    }
}

