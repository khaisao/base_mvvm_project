package com.example.setting.ui.viewPager

import com.example.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor() : BaseViewModel() {

    private var isLoadedData = false

    fun fetchData(id: String) {
        if (!isLoadedData) {
            isLoadedData = true
        }
    }
}