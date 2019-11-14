package com.example.adiphong.rx2

import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class FromArrayTest {

    private var testArray = arrayOf("hello", "world")

    @Test
    fun flowableJust() {
        Flowable.fromArray(*testArray)
                .subscribe { s -> println("---------------flowable  result $s") }
    }

    @Test
    fun observableJust() {
        Observable.fromArray(*testArray)
                .subscribe { s -> println("---------------observable result $s") }
    }
}
