package com.eebros.myapplication.util

import android.app.Activity
import android.app.AlertDialog
import com.eebros.myapplication.R
import com.eebros.myapplication.data.local.ErrorMessageMapper
import com.eebros.myapplication.data.local.ErrorMessageMapper.Companion.errorMap

open class AlertDialogMapper(private val activity: Activity, private val errorResources: Int) {
    open fun showAlertDialog() {
        var errorResources = errorResources
        if (errorMap[this.errorResources] === null) {
            errorResources = R.string.default_error_message
        }
        AlertDialog.Builder(activity)
            .setTitle(R.string.error_occured)
            .setMessage(activity.getString(ErrorMessageMapper().getErrorMessage(errorResources)))
            .setPositiveButton(R.string.ok) { _, _ -> }
            .setCancelable(true)
            .show()
    }
    open fun showSuccessAlertDialog() {
        var errorResources = errorResources
        if (errorMap[this.errorResources] === null) {
            errorResources = R.string.done
        }
        AlertDialog.Builder(activity)
            .setTitle(R.string.successful_operation)
            .setMessage(activity.getString(errorMap[errorResources]!!))
            .setPositiveButton(R.string.ok) { _, _ -> }
            .setCancelable(true)
            .show()
    }

}