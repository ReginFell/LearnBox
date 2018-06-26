package com.regin.learnbox.util.rx

import android.util.Log
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class ShityCoroutine<T>(val channel: Channel<T>) : Subscriber<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(s: Subscription?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNext(t: T) {
        Log.d("test", t.toString())
        launch { channel.send(t) }
    }

    override fun onError(t: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}