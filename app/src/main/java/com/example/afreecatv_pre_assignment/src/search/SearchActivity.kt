package com.example.afreecatv_pre_assignment.src.search

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.R
import com.example.afreecatv_pre_assignment.config.ApplicationClass.Companion.sSharedPreferences
import com.example.afreecatv_pre_assignment.config.BaseActivity
import com.example.afreecatv_pre_assignment.databinding.ActivitySearchBinding
import com.example.afreecatv_pre_assignment.src.search.models.SearchResponse

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.searchConst1Img1.setOnClickListener(){
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.search_fragment, SearchFragment())
                .commitAllowingStateLoss()

            var q = binding.searchConst1Edt1.text.toString()

            preferencesEditor.putString("q", q)
            preferencesEditor.apply()

            if(q.isNotEmpty()){
                binding.searchConst1Txt1.visibility = View.VISIBLE
                binding.searchConst1Txt1.text = q
            }
        }
    }
}