package com.haslan.profilescreen.common

import io.reactivex.disposables.Disposable

fun clearPresenterDispose(disposable: Disposable?) {
    if (disposable != null && !disposable.isDisposed) {
        disposable.dispose()
    }
}