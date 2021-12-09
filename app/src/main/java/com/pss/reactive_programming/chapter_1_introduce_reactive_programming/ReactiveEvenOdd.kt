package com.pss.reactive_programming.chapter_1_introduce_reactive_programming

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

fun main(args: Array<String>){
    subject()
}

//리액티브한 방법
/*
출력값
The number is Even
The number is Odd
*/
private fun subject(){
    val subject : Subject<Int> = PublishSubject.create()
    subject.map({ if (it%2 == 0) true else false }).subscribe({
        println("The number is ${(if (it) "Even" else "Odd" )}")
    })

    subject.onNext(2)
    subject.onNext(5)
}