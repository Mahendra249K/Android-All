package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.all.R;

public class WebView_Fragment extends Fragment {
    Button seach_url_btn;
    EditText url_string;
    WebView webView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        webView = (WebView) view.findViewById(R.id.web_viewwwww);
        url_string = (EditText) view.findViewById(R.id.url_string);
        seach_url_btn = (Button) view.findViewById(R.id.seach_url_btn);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        seach_url_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (url_string.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter URL", Toast.LENGTH_SHORT).show();
                    return;
                }
                webView.loadUrl(WebView_Fragment.this.url_string.getText().toString());
            }
        });
        return view;
    }
}
