package org.d3if3056.mobpro1.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.model.BangunDatar
import org.d3if3056.hitung_luassegitiga.network.ApiStatus
import org.d3if3056.hitung_luassegitiga.network.BangunDatarApi
import org.d3if3056.hitung_luassegitiga.network.UpdateWorker
import java.util.concurrent.TimeUnit

class ListViewModel : ViewModel() {
    private val data = MutableLiveData<List<BangunDatar>>()
    private val status = MutableLiveData<ApiStatus>()
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(BangunDatarApi.service.getListBangunDatar())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("ListViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }
    // Data ini akan kita ambil dari server di langkah selanjutnya
    fun getData(): LiveData<List<BangunDatar>> = data

    fun getStatus(): LiveData<ApiStatus> = status
    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}