package com.hungn.safeliving

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var btnAdd: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ẩn thanh tiêu đề để tạo giao diện giống hình ảnh
        supportActionBar?.hide()

        // Ánh xạ các view
        btnAdd = findViewById(R.id.btnAdd)

        // Thêm sự kiện click cho nút thêm
        btnAdd?.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Thêm thông báo mới",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}