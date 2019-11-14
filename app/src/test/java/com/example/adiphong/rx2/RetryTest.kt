package com.example.adiphong.rx2

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class RetryTest {

    @Test
    fun flowableJust() {
        Flowable.just(1, 0, 2)
                .map { integer -> 5 / integer }
                .retry(1)
                .subscribe { s -> println("---------------flowable  result " + s!!) }
    }

    @Test
    fun observableJust() {
        Observable.just(1, 0, 2)
                .map { integer -> 5 / integer }
                .retry(1)
                .subscribe { s -> println("---------------observable result " + s!!) }
    }

    @Test
    fun maybeJust() {
        // can be only one data
        Maybe.just(1)
                .map { integer -> 5 / integer }
                .retry(1)
                .subscribe { s -> println("---------------maybe result " + s!!) }
    }

    @Test
    fun singleJust() {
        // can be only one data
        Single.just(1)
                .map { integer -> 5 / integer }
                .retry(1)
                .subscribe { s -> println("---------------single result " + s!!) }
    }
}
