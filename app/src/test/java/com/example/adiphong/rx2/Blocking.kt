package com.example.adiphong.rx2

import io.reactivex.Observable
import org.junit.Test
import java.util.*

/**
 * Created by adiphong on 28/11/2017 AD.
 */

class Blocking {


    @Test
    fun blockingIterable() {
        val integers = Observable.fromArray("Hello", "World")
                .map { s -> s.length }
                .blockingIterable()
        println("--------- integer$integers")
        //--------- integerio.reactivex.internal.operators.observable.BlockingObservableIterable@1a968a59
    }

    @Test
    fun blockingGet() {
        val integer = Observable.fromIterable(Arrays.asList("Hello", "World"))
                .toList()
                .map { it.size }
                .blockingGet()
        println("--------- integer" + integer!!)
        //--------- integer2
    }
}
