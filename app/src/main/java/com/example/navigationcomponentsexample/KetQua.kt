package com.example.navigationcomponentsexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import android.webkit.WebView
import android.webkit.WebViewClient


//class KetQua : Fragment(),View.OnClickListener {
class KetQua : Fragment() {
    var navController: NavController? = null
    private lateinit var webView: WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ket_qua, container, false)
        webView = view.findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        // Cấu hình WebView
        webView.settings.apply {
            javaScriptEnabled = true // Bật hỗ trợ JavaScript nếu cần
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        // Load trang web
        val url = "http://api.xosodo.vn/webview/soicaudetail?loto=90&p1=7&p2=19&limit=4&provinceId=1&dayPrize=08/11/2018&type=1"
        webView.loadUrl(url)

        // Xóa thẻ sau khi trang web được tải hoàn thành
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                removeElementFromWebView("/html/body/section/div[1]")
            }
        }

        return view
    }
    private fun removeElementFromWebView(xpath: String) {
        val js = """
            var element = document.evaluate('$xpath', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
            if (element) {
                element.parentNode.removeChild(element);
            }
        """.trimIndent()

        webView.evaluateJavascript(js, null)
    }
}