package com.example.adiphong.rx2

import org.junit.Test

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class CompositeDisposableTest {
    private var disposable = CompositeDisposable()

    //just
    //////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableJust() {
        disposable.add(Flowable
                .just("Hello", "World")
                .subscribe { s -> println("---------------flowable  result $s") }
        )
    }

    @Test
    fun observableJust() {
        disposable.add(Observable
                .just("Hello", "World")
                .subscribe { s -> println("---------------observable result $s") }
        )
    }

    @Test
    fun maybeJust() {
        // can be only one data
        disposable.add(Maybe.just("Hello")
                .subscribe { s -> println("---------------maybe result $s") }
        )
    }

    @Test
    fun singleJust() {
        // can be only one data
        disposable.add(Single.just("Hello")
                .subscribe { s -> println("---------------single result $s") }
        )
    }

    @Test
    fun completeAbleJust() {
        //can be only one data
        disposable.add(Completable.create { emitter -> emitter.onComplete() }
                .subscribe(
                        { println("--------- completableCreate onComplete ") },
                        { println("--------- completableCreate onError") }
                )
        )
    }
}
