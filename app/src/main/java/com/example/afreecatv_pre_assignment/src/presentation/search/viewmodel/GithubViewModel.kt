package com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afreecatv_pre_assignment.src.data.model.GithubRepository
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import kotlinx.coroutines.launch
import java.net.ConnectException

class GithubViewModel(private val repository : GithubRepository) : ViewModel() {
    val getGithubDataRepository = MutableLiveData<GithubResponse>()

    fun getGithubData(q : String, perPage : Int, page : Int) {
        viewModelScope.launch {
            try {
                repository.getGithub(q,perPage,page).let {
                    response -> Log.d("api_request", response.code().toString())
                    Log.d("api_request_url::", response.raw().request.url.toString())
                    Log.d("get_user_api", response.code().toString() + " " + response.message())

                    if (response.isSuccessful) {
                        if (response.code() == 200) {
                            response.body()?.code = response.code()
                            Log.e("12345", "${response.body()}")
                            getGithubDataRepository.postValue((response.body()))
                        } else {
                            getGithubDataRepository.postValue(
                                GithubResponse(false, listOf(),0).apply {
                                    code = response.code()
                                })
                        }
                    } else {
                        throw RuntimeException("response is Failed.")
                    }
                }
            } catch (e: ConnectException) {
                e.printStackTrace()
                Log.d("api_exception", e.toString())
            } catch (e : Exception) {
                e.printStackTrace()
                Log.d("api_exception", e.toString())
            }
        }
    }
}