package org.d3if3056.hitung_luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


//    private fun showResult(result: HasilSegitiga) {
//        binding.luasTextView.text = getString(R.string.luasSegitiga_x, result.hasil)
//    }
}