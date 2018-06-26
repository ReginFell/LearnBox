package com.regin.learnbox.models.core

sealed class State {
    class Loading : State()
    data class Content<T>(val content: T) : State()
    class Error : State()
    class Absolete : State()
    class Empty : State()
}