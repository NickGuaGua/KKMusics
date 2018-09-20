package com.guagua.kkmusics

interface BasePresenter<T>{
    fun setView(view: T)
}