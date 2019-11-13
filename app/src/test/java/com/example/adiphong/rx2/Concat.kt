package com.example.adiphong.rx2

import org.junit.Test

import io.reactivex.Observable

class Concat {

    @Test
    fun concatCreate() {
        val input = 0
        val observable1 = Observable.create<Int> { emitter ->
            if (!emitter.isDisposed) {
                val result = 1
                // result /= input;
                emitter.onNext(result)
                emitter.onComplete()
            }
        }

        val observable2 = Observable.create<String> { emitter ->
            if (!emitter.isDisposed) {
                val result = 2
                //                result /= input;
                emitter.onNext("" + result)
                emitter.onComplete()
            }
        }

        Observable.concat(observable1, observable2)
                .doOnError { println("--------- doOnError") }
                .onErrorResumeNext(Observable.never())
                .subscribe(
                        { s -> println("-------------- on next $s") },
                        { throwable -> println("----------- error $throwable") },
                        { println("----------- on complete") }
                )
    }
}
