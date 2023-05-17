package org.d3if3056.hitung_luassegitiga.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.databinding.FragmentHitungPersegipanjangBinding
import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang

class HitungPersegiPanjangFragment : Fragment() {
    private lateinit var binding: FragmentHitungPersegipanjangBinding

    private val viewModel: HitungPersegiPanjangViewModel by lazy {
        ViewModelProvider(requireActivity())[HitungPersegiPanjangViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHitungPersegipanjangBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnpersegipanjangHitung.setOnClickListener { hitungPersegiPanjang() }
        binding.btnSharePersegiPanjang.setOnClickListener { shareData() }
        viewModel.getHasilPersegiPanjang().observe(requireActivity(),{showResult(it)})
    }

    private fun hitungPersegiPanjang() {
        val panjang = binding.panjangEditText.text.toString()
        val lebar = binding.lebarEditText.text.toString()
        var hasil = 0
        when {
            TextUtils.isEmpty(panjang) -> {
                Toast.makeText(context, "Input Pertama Belum Ada!", Toast.LENGTH_SHORT).show()
                binding.panjangEditText.requestFocus()
            }
            TextUtils.isEmpty(lebar) -> {
                Toast.makeText(context, "Input Kedua Belum Ada!", Toast.LENGTH_SHORT).show()
                binding.lebarEditText.requestFocus()
            }
            else -> {
                hasil = (panjang.toInt() * lebar.toInt() ) * 2
                binding.luasPersegiPanjangTextView.text = getString(R.string.luasPersegiPanjang_x, hasil)
            }
        }
        viewModel.hitungPersegiPanjang(
            panjang.toFloat(),
            lebar.toFloat()
        )
    }
    private fun showResult(result : HasilPersegiPanjang?) {
        if (result == null) return
        binding.luasPersegiPanjangTextView.text = getString(R.string.luasPersegiPanjang_x, result.hasil)
        binding.btnSharePersegiPanjang.visibility = View.VISIBLE
    }

    private fun shareData() {
        val message = getString(
            R.string.bagikan_template_persegi_panjang,
            binding.panjangEditText.text,
            binding.lebarEditText.text
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
