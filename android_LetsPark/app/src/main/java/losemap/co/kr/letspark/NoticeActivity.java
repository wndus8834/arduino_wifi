package losemap.co.kr.letspark;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NoticeActivity extends Activity {

    WebView mainWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        mainWebView = (WebView) findViewById(R.id.mainWebView);
        mainWebView.getSettings().setJavaScriptEnabled(true);
        mainWebView.loadUrl("https://pei5171.wixsite.com/letspark/blank");
        mainWebView.setInitialScale(280);
        mainWebView.setWebViewClient(new aaaWebviewClient());
    }

    private class aaaWebviewClient extends WebViewClient {
        public boolean shouldOverrideUriLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}