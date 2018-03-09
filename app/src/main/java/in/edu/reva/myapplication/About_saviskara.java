package in.edu.reva.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_saviskara extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // title bar name
        getSupportActionBar().setTitle("About Saviskara");
        simulateDayNight(/* DAY */ 0);
        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .setDescription("Saviskara is a Techno-Cultural fest.\nOrganised by the school of Computing and Techmology.\nReva University Bangalore.\n" + "It's governed by RACIT ")
                .isRTL(false)
                .setImage(R.drawable.saviskaraboutus)
                .addGroup("Connect with us")
                .addEmail("saviskaracit@gmail.com")
                .addWebsite("https://saviskara.github.io/2018/")
                .addFacebook("SCHOOL.C.IT/")
                .create();

        setContentView(aboutPage);
    }
    void simulateDayNight(int currentSetting)
    {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO)
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES)
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        }
        else if (currentSetting == FOLLOW_SYSTEM)
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}
