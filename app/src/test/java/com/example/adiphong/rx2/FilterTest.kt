package com.example.adiphong.rx2

import org.junit.Test

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class FilterTest {

    @Test
    fun flowableJust() {
        Flowable.just("Hello", "World")
                .filter { s -> s == "Hello" }
                .subscribe { s -> println("---------------flowable  result $s") }
    }

    @Test
    fun observableJust() {
        Observable.just("Hello", "World")
                .filter { s -> s == "Hello" }
                .subscribe { s -> println("---------------observable result $s") }
    }

    @Test
    fun maybeJust() {
        // can be only one data
        Maybe.just("Hello")
                .filter { s -> s == "Hello" }
                .subscribe { s -> println("---------------maybe result $s") }
    }

    @Test
    fun singleJust() {
        // can be only one data
        Single.just("Hello")
                .filter { s -> s == "Hello" }
                .subscribe { s -> println("---------------single result $s") }
    }

    @Test
    fun singleJusts() {
        // can be only one data
        Single.just(false)
                .filter { s -> s }
                .subscribe { s -> println("---------------single result " + s!!) }
    }
}
