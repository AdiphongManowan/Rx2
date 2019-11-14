package com.example.adiphong.rx2

import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class TakeTest {

    @Test
    fun flowableJust() {
        Flowable.just("Hello", "World")
                .take(1)
                .subscribe { s -> println("---------------flowable  result $s") }
    }

    @Test
    fun observableJust() {
        Observable.just("Hello", "World")
                .take(1)
                .subscribe { s -> println("---------------observable result $s") }
    }

    @Test
    fun observableJust2() {
        Observable.fromIterable(listOf("a", "b", "c", "d", "e", "f", "g", "h", "i"))
                .subscribe { s -> println("---------------observable result $s") }

//        Observable.fromArray(listOf("a", "b", "c", "d", "e", "f", "g", "h", "i"))
//                .map { strings ->
//                    println("---------- ")
//                    strings.size
//                }
//                .take(5)
//                .subscribe { s -> println("---------------observable result " + s!!) }
    }
}
