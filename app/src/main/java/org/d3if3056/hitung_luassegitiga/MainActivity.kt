package org.d3if3056.hitung_luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if3056.hitung_luassegitiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            val alas = binding.alasInp.text.toString()
            val tinggi = binding.tinggiInp.text.toString()
            var hasil = 0
            when {
                TextUtils.isEmpty(alas) -> {
                    Toast.makeText(this, "Input Pertama Belum Ada!", Toast.LENGTH_SHORT).show()
                    binding.alasInp.requestFocus()
                }
                TextUtils.isEmpty(tinggi) -> {
                    Toast.makeText(this, "Input Kedua Belum Ada!", Toast.LENGTH_SHORT).show()
                    binding.tinggiInp.requestFocus()
                }
                else -> {
                    hasil = (alas.toInt() * tinggi.toInt() )/2
                    binding.luasTextView.text = hasil.toString()
                }
            }
        }
    }
}