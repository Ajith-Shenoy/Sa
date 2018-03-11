package in.edu.reva.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_saviskara extends AppCompatActivity
{
    String Email ="saviskaracit@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // title bar name
        getSupportActionBar().setTitle("About Saviskara");
        View aboutPage = new AboutPage(this)
                .setDescription("Saviskara is a Techno-Cultural fest.\nOrganised by the school of Computing and Techmology.\nReva University Bangalore.\n" + "It's governed by RACIT ")
                .isRTL(false)
                .setImage(R.drawable.saviskaraboutus)
                .addGroup("Connect with us")
                //.addEmail("saviskaracit@gmail.com")
                .addWebsite("https://saviskara.github.io/2018/")
                .addFacebook("SCHOOL.C.IT/")
                .addItem(email())
                .create();
        setContentView(aboutPage);
    }
    // Custom Email element
    Element email() {
        Element copyRightsElement = new Element();
        copyRightsElement.setIconDrawable(R.drawable.mail);
        copyRightsElement.setGravity(Gravity.START);
        copyRightsElement.setTitle(getString(R.string.emailUs));
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + Email));
                startActivity(intent);
            }
        });
        return copyRightsElement;

    }

}
