package com.pss.reactive_programming.chapter_1_introduce_reactive_programming

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    maybe()
}

//함수형 프로그래밍 모나드
private fun maybe(){
    val maybeValue: Maybe<Int> = Maybe.just(14)
    maybeValue.subscribeBy(
        onComplete = { println("Completed Empty")},
        onError = { println("Error $it")},
        onSuccess = { println("Completed with value $it")}
    )

    val maybeEmpty:Maybe<Int> = Maybe.empty()
    maybeEmpty.subscribeBy(
        onComplete = { println("Completed Empty")},
        onError = { println("Error $it")},
        onSuccess = { println("Completed with value $it")}
    )
}