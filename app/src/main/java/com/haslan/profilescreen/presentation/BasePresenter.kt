package com.haslan.profilescreen.presentation

interface BasePresenter<in T> {

    fun setView(view: T)

    fun clearPresenterDispose()
}