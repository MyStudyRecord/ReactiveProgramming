package com.pss.reactive_programming.chapter_1_introduce_reactive_programming

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


fun main(args: Array<String>){
    iterator()
    observable()
}

//일반적인 방법
private fun iterator(){
    val list:List<Any> = listOf("일",2,3,"사","오","육",7.7) //1
    val iterator = list.iterator() //2
    while(iterator.hasNext()){ //3
        println(iterator.next()) //4
    }
}

//observable 로 된 방법
private fun observable(){
    val list:List<Any> = listOf("일",2,3,"사","오","육",7.7)
    val observable : Observable<Any> = list.toObservable()

    observable.subscribeBy(
        onNext = { println(it)}, //모든 변경 사항이 여기로 푸쉬
        onError = {it.printStackTrace()}, //에러가 났을때
        onComplete = { println("Done!")} //모든 데이터가 푸쉬됐을 때
    )
}