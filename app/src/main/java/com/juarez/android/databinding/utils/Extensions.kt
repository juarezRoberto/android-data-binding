package com.juarez.android.databinding.utils

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.requestPermission(
    permission: String,
    onResult: (result: PermissionResult) -> Unit,
) {
    when {
        ContextCompat.checkSelfPermission(
            requireContext(),
            permission
        ) == PackageManager.PERMISSION_GRANTED -> onResult(PermissionResult.GRANTED)
        shouldShowRequestPermissionRationale(permission) -> onResult(PermissionResult.RATIONALE)
        else -> onResult(PermissionResult.DENIED)
    }
}

enum class PermissionResult {
    GRANTED, DENIED, RATIONALE
}
