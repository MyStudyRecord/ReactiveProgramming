package com.pss.reactive_programming.chapter_2_observables_observers_subjects

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import java.lang.Exception

fun main(args: Array<String>) {
    observableCreateFunc()
}

//Observable.create 메서드 이해
private fun observableCreateFunc() {
    val observer: Observer<String> = object : Observer<String> {

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }

        override fun onError(e: Throwable) {
            println("Error Occured $e")
        }

        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(t: String) {
            println("Next $t")
        }
    }

    //옵저버블 생성
    val observable: Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    //옵저버가 옵저버블 구독
    observable.subscribe(observer)

    //옵저버블 생성
    val observable2: Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Exception"))
    }

    //옵저버가 옵저버블 구독
    observable2.subscribe(observer)
}