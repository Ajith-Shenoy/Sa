package in.edu.reva.myapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web_Visit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__visit);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://saviskara.github.io/2018/");
        //Enable JS
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Inapp Navigation (One Way)
        myWebView.setWebViewClient(new WebViewClient());

    }


}
