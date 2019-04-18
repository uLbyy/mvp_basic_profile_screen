package com.haslan.profilescreen.data.api

import io.reactivex.subscribers.DisposableSubscriber

open class ApiSubscriber<T> : DisposableSubscriber<T>() {

    override fun onNext(t: T) {
        success(t)
        complete()
    }

    override fun onError(t: Throwable?) {
        complete()
    }

    override fun onComplete() {
        complete()
    }

    open fun success(t: T) {}

    open fun error(t: T) {}

    open fun complete() {}
}