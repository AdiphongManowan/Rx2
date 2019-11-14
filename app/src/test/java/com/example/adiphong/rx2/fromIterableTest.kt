package com.example.adiphong.rx2

import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test
import java.util.*

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class fromIterableTest {

    private var testList = Arrays.asList("hello", "world")

    @Test
    fun flowableJust() {
        Flowable.fromIterable(
                testList
        ).subscribe { s ->
            println("---------------flowable  result $s")
        }
    }

    @Test
    fun observableJust() {
        Observable.fromIterable(
                testList
        ).subscribe { s ->
            println("---------------observable result $s")
        }
    }
}
