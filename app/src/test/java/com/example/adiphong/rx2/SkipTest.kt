package com.example.adiphong.rx2

import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class SkipTest {

    @Test
    fun flowableJust() {
        Flowable.just("Hello", "World")
                .skip(1)
                .subscribe { s -> println("---------------flowable  result $s") }
    }

    @Test
    fun observableJust() {
        Observable.just("Hello", "World")
                .skip(1)
                .subscribe { s -> println("---------------observable result $s") }
    }
}
