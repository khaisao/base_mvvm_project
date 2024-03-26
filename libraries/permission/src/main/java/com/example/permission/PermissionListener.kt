package com.example.permission

interface PermissionListener {
    fun onPermissionGranted(requestCode: Int?)
    fun onPermissionDenied(
        requestCode: Int?,
        permissions: List<PermissionStatus>,
        isDoNotAskAgain: Boolean
    )
}