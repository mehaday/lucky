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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_ket_qua, container, false)

        // Tạo một instance của fragment mới
        val myFragment = ketQuaXoSo()

        // Thêm fragment mới vào fragment gốc
        childFragmentManager.beginTransaction()
            .add(R.id.abcds, myFragment)
            .commit()

        return rootView
    }
}