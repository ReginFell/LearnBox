package com.regin.learnbox.presentation.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.regin.learnbox.BuildConfig

private const val HOST: String = BuildConfig.HOST

fun navigateTo(context: Context, path: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$HOST/$path"))
    intent.`package` = context.packageName
    intent.addCategory(Intent.CATEGORY_BROWSABLE)
    context.startActivity(intent)
}