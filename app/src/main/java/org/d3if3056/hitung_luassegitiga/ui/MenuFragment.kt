package org.d3if3056.hitung_luassegitiga.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSegitiga.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_MenuFragment_to_hitungSegitigaFragment
            )
        }
        binding.btnPersegiPanjang.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_MenuFragment_to_hitungPersegiPanjangFragment
            )
        }
        binding.btnListBangunDatar.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_MenuFragment_to_listFragment
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_MenuFragment_to_historiFragment
                )
                return true
            }
        }
            return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

}