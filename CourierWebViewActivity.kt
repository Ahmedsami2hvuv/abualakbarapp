import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class CourierWebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courier_webview)

        webView = findViewById(R.id.courierWebView)

        // إعداد WebView
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        // رابط خاص بالمندوب (غيّره حسب كل مندوب لاحقاً)
        val courierUrl = "https://your-courier-link.com"
        webView.loadUrl(courierUrl)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}