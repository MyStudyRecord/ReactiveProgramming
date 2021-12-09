package com.pss.reactive_programming.chapter_2_observables_observers_subjects

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import java.lang.Exception

fun main(args: Array<String>) {
    observableMoveWay()
}

//옵저버블이 동작하는 방법
private fun observableMoveWay(){
    val observer: Observer<Any> = object : Observer<Any>{

        //옵저버가 옵저버블을 구독할 때 호출
        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        //옵저버블이 내보내는 각 아이템에 대해 호출
        override fun onNext(t: Any) {
            println("Next $t")
        }

        //옵저버블에 오류가 발생했을 때 호출
        override fun onError(e: Throwable) {
            println("Error Occured $e")
        }

        //오류 없이 모든 아이템을 처리하면 호출
        override fun onComplete() {
            println("All Completed")
        }
    }

    //list(val observable)을 통해 옵저버블을 생성한다
    val observable : Observable<Any> = listOf("일","둘","넷",9).toObservable()

    //observer 가 observable 을 구독한다
    observable.subscribe(observer)

    //옵저버블을 다시 생성하고 목록을 아이템으로 가진다
    val observableOnList: Observable<List<Any>> = Observable.just(
        listOf("one",2,3),
        listOf("List with Single Item"),
        listOf(1,2,3,4,5,6)
    )
    observableOnList.subscribe(observer)
}