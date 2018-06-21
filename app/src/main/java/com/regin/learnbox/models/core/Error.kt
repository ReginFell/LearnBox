package com.regin.learnbox.models.core

data class Error(val throwable: Throwable, val retry: (() -> Unit)? = null)