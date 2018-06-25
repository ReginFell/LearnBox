package com.regin.learnbox.models.core

data class LocalError(val throwable: Throwable, val retry: (() -> Unit)? = null)