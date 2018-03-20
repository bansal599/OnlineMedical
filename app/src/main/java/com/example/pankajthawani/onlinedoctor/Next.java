package com.example.pankajthawani.onlinedoctor;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Next extends AppCompatActivity {
    WebView webView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        webView = (WebView) findViewById(R.id.wb);
        webView.getSettings().setJavaScriptEnabled(true);
        String pdfLoc = "http://drive.google.com/viewerng/viewer?embedded=true&url=";
        webView.setWebViewClient(new mywebclient());
        progressDialog=new ProgressDialog(Next.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("loading...");
        progressDialog.setCancelable(false);
        webView.loadUrl("https://drive.google.com/file/d/1_g2YK3f_JfgxzneJFMFqHHUiXjlE55Cs/view?usp=sharing" + pdfLoc);

    }


    private class mywebclient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
           progressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss();
        }
    }

}
