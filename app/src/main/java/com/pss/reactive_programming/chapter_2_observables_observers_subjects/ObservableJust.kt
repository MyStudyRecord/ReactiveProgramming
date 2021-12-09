package com.pss.reactive_programming.chapter_2_observables_observers_subjects

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    observableJustFunc()
}

private fun observableJustFunc() {
    val observer: Observer<Any> = object : Observer<Any> {

        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        override fun onNext(t: Any) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured $e")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }

    Observable.just("A String").subscribe(observer)
    Observable.just(54).subscribe(observer)
    Observable.just(
        listOf(
            "String 1", "String 2", "String 3", "String 4"
        )
    ).subscribe(observer)
    Observable.just(
        mapOf(
            Pair("key1", "value1"),
            Pair("key2", "value2")
        )
    ).subscribe(observer)
    Observable.just(arrayListOf(1,2,3,4,5)).subscribe(observer)
    Observable.just("afaf","aaaa","bbbbb").subscribe(observer)
}