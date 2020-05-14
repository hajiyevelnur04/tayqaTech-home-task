package com.eebros.myapplication

open class ErrorMessageMapper {
    companion object{
        val errorMap = hashMapOf<Int, Int>()
    }
    open fun getErrorMessage(errorCode: Int): Int{
        return if (errorMap[errorCode] === null){
            R.string.some_error
        } else {
            errorMap[errorCode]!!
        }
    }

    open fun saveDataToMap(){
        //Local errors
        errorMap[1] = R.string.error_local

        //Remote error
        errorMap[1] = R.string.error_remote
    }
}
