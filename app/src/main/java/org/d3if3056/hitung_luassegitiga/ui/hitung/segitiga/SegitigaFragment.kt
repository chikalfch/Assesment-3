package org.d3if3056.hitung_luassegitiga.ui.hitung.segitiga

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.databinding.FragmentHitungSegitigaBinding
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDb
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

class SegitigaFragment : Fragment()
{
    private lateinit var binding: FragmentHitungSegitigaBinding

    private val viewModel: SegitigaViewModel by lazy {
        val db = BangunDatarDb.getInstance(requireContext())
        val factory = SegitigaFactory(db.dao)
        ViewModelProvider(this, factory)[SegitigaViewModel::class.java]
    }
    private fun hitungSegitiga(alas: Float, tinggi: Float): HasilSegitiga {
        val hasil = (alas * tinggi) / 2
        return HasilSegitiga(hasil)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHitungSegitigaBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnsegitigaHitung.setOnClickListener { hitungSegitiga() }
        binding.btnShareSegitiga.setOnClickListener { shareData() }
        viewModel.getHasilSegitiga().observe(requireActivity(),{showResult(it)})
    }

    private fun hitungSegitiga() {
        val alas = binding.alasEditText.text.toString()
        val tinggi = binding.alasEditText.text.toString()
        var hasil = 0
        when {
            TextUtils.isEmpty(alas) -> {
                Toast.makeText(context, "Input Pertama Belum Ada!", Toast.LENGTH_SHORT).show()
                binding.alasEditText.requestFocus()
            }
            TextUtils.isEmpty(tinggi) -> {
                Toast.makeText(context, "Input Kedua Belum Ada!", Toast.LENGTH_SHORT).show()
                binding.alasEditText.requestFocus()
            }
            else -> {
                viewModel.hitungSegitiga(
                    alas.toFloat(),
                    tinggi.toFloat()
                )
            }
        }
    }
    private fun showResult(result : HasilSegitiga?) {
        if (result == null) return
        binding.luasSegitigaTextView.text = getString(R.string.luasPersegiPanjang_x, result.hasil)
        binding.btnShareSegitiga.visibility = View.VISIBLE
    }

    private fun shareData() {
        val message = getString(
            R.string.bagikan_template_persegi_panjang,
            binding.alasEditText.text,
            binding.tinggiEditText.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager
            ) != null
        ) {
            startActivity(shareIntent)
        }
    }
}