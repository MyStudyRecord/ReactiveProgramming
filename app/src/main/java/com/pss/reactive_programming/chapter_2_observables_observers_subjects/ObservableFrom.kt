package com.pss.reactive_programming.chapter_2_observables_observers_subjects

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/*
출력값
New Subscription
Next 문자1
Next 문자2
Next 문자3
Next 문자4
All Completed
New Subscription
Next From Callable
All Completed
New Subscription
Next Hello From Future
All Completed
*/

fun main(args: Array<String>) {
    observableFromFunc()
}

private fun observableFromFunc(){
    //옵저버 생성
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

    val list = listOf("문자1","문자2","문자3","문자4")
    //Observable.fromIterable 메서드를 사용해 Iterable 인스턴스로부터 옵저버블 생성
    val observableFromIterable : Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = object : Callable<String>{
        override fun call(): String {
            return "From Callable"
        }
    }
    //Observable.fromCallable 메서드를 호출해 Callable 인스턴스에서 옵저버블 생성
    val observableFromCallable : Observable<String> = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)


    val future : Future<String> = object : Future<String>{
        override fun cancel(p0: Boolean): Boolean {
            return false
        }

        override fun isCancelled(): Boolean {
            return false
        }

        override fun isDone(): Boolean {
            return true
        }

        override fun get(): String {
            return "Hello From Future"
        }

        override fun get(p0: Long, p1: TimeUnit?): String {
            return "Hello From Future"
        }
    }

    //Observable.fromFuture 메서드를 호출해 Future 인스턴스에서 Observable 파생
    val observableFromFuture:Observable<String> = Observable.fromFuture(future)
    observableFromFuture.subscribe(observer)
}