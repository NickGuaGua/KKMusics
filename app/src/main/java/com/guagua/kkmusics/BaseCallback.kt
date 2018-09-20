package com.guagua.kkmusics

interface BaseCallback<T>{
    fun onDataReturn(data: T);
    fun onDataNotAvailable();
}