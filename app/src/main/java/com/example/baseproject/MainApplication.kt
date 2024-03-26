package com.example.baseproject

import com.example.core.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication @Inject constructor() : BaseApplication()