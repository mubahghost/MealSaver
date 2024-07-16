package com.codecx.mealsaver.sealclasses

sealed class DataStates{
    object Loading:DataStates()
    object Initial:DataStates()
    class Success<T>(val result:T):DataStates()
    class Error(val error:java.lang.Exception):DataStates()
}
