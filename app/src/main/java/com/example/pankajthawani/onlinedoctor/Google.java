package com.example.pankajthawani.onlinedoctor;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Google extends AppCompatActivity {
    WebView webView1;
   // ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        webView1=findViewById(R.id.webview);
        webView1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView1.setWebViewClient(new mywebclient());
        webView1.loadUrl("https://www.google.co.in/");
     //   progressDialog.setMessage("Loading...");
     //   progressDialog.setTitle("Please wait");
       // progressDialog.setCancelable(false);
       // progressDialog.setIcon(R.mipmap.images);

    }
    private class mywebclient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
             //   progressDialog.show();
            }

        @Override
        public void onPageFinished(WebView view, String url)
        {
        //    progressDialog.dismiss();
        }
    }

}
