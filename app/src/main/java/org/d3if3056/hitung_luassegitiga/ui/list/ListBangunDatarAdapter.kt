package org.d3if3056.hitung_luassegitiga.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.databinding.ListItemBinding
import org.d3if3056.hitung_luassegitiga.model.BangunDatar
import org.d3if3056.hitung_luassegitiga.network.BangunDatarApi

class ListBangunDatarAdapter: RecyclerView.Adapter<ListBangunDatarAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bangundatar: BangunDatar) = with(binding) {
            namaTextView.text = bangundatar.nama
            bdLuasTextView.text = bangundatar.luas
            imageView.setImageResource(R.drawable.persegipanjang)
            Glide.with(imageView.context)
                .load(BangunDatarApi.getBangunDatarUrl(bangundatar.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)


            root.setOnClickListener {
                val message = root.context.getString(R.string.message, bangundatar.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private val data = mutableListOf<BangunDatar>()
    fun updateData(newData: List<BangunDatar>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}