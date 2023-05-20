package org.d3if3056.hitung_luassegitiga.ui.histori

import org.d3if3056.hitung_luassegitiga.db.bangundatar.PersegiPanjangEntity


import android.graphics.drawable.GradientDrawable
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.databinding.ItemHistoriBinding
import org.d3if3056.hitung_luassegitiga.db.bangundatar.SegitigaEntity
import org.d3if3056.hitung_luassegitiga.db.bangundatar.hitungBangunDatar
import java.util.*

class HistoriAdapter :
    ListAdapter<PersegiPanjangEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<PersegiPanjangEntity>() {
                override fun areItemsTheSame(
                    oldData: PersegiPanjangEntity, newData: PersegiPanjangEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: PersegiPanjangEntity, newData: PersegiPanjangEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.N)
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(item: PersegiPanjangEntity) = with(binding) {
            val hasilPersegiPanjang = item.hitungBangunDatar()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            luasTextView.text = root.context.getString(
                R.string.hasil_x,
                hasilPersegiPanjang.hasil
            )
            dataTextView.text = root.context.getString(
                R.string.data_x,
                item.panjang, item.lebar
            )
        }
        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(item: SegitigaEntity) = with(binding) {
            val hasilSegitiga = item.hitungBangunDatar()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            luasTextView.text = root.context.getString(
                R.string.hasil_x,
                hasilSegitiga.hasil
            )
            dataTextView.text = root.context.getString(
                R.string.data_x,
                item.alas, item.tinggi
            )
        }
    }

}