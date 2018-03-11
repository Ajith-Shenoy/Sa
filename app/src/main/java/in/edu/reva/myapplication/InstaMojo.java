package in.edu.reva.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InstaMojo extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta_mojo);
        myWebView = (WebView) findViewById(R.id.InstaMojo);
        myWebView.loadUrl("https://www.instamojo.com/@Saviskara/");
        //Enable JS
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Inapp Navigation
        myWebView.setWebViewClient(new WebViewClient());
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return super.onKeyDown(keyCode, event);
    }
}


