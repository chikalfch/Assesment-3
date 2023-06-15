package org.d3if3056.mobpro1.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3056.hitung_luassegitiga.databinding.FragmentListBinding
import org.d3if3056.hitung_luassegitiga.ui.list.ListBangunDatarAdapter


class ListFragment : Fragment() {
    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this)[ListViewModel::class.java]
    }
    private lateinit var binding: FragmentListBinding
    private lateinit var myAdapter: ListBangunDatarAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        myAdapter = ListBangunDatarAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }
    }
}