package com.example.adiphong.rx2

import org.junit.Test

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Created by adiphong on 28/11/2017 AD.
 */

class CreateTest {

    @Test
    fun flowableCreate() {
        Flowable.create<Any>({ emitter ->
            if (!emitter.isCancelled) {
                emitter.onNext("hello")
                emitter.onNext("world")
                emitter.onComplete()
            }
        }, BackpressureStrategy.BUFFER).subscribe(
                { s -> println("--------- flowableCreate onNext $s") },
                { println("--------- flowableCreate onError") },
                { println("--------- flowableCreate onComplete") }
        )
    }

    @Test
    fun observableCreate() {
        Observable.create<Any> { emitter ->
            if (!emitter.isDisposed) {
                emitter.onNext("hello")
                emitter.onNext("world")
                emitter.onComplete()
            }
        }.subscribe(
                { s -> println("--------- observableCreate onNext $s") },
                { println("--------- observableCreate onError") },
                { println("--------- observableCreate onComplete") }
        )
    }

    @Test
    fun maybeCreate() {
        Maybe.create<Any> { emitter ->
            if (!emitter.isDisposed) {
                emitter.onSuccess("hello")
                emitter.onSuccess("world")
                emitter.onComplete()
            }
        }.subscribe(
                { s -> println("--------- maybeCreate onNext $s") },
                { println("--------- maybeCreate onError") },
                { println("--------- maybeCreate onComplete") }
        )
    }

    @Test
    fun singleCreate() {
        Single.create<Any> { emitter ->
            if (!emitter.isDisposed) {
                emitter.onSuccess("hello")
                emitter.onSuccess("world")
            }
        }.subscribe(
                { s -> println("--------- singleCreate onNext $s") },
                { println("--------- singleCreate onError") }
        )
    }

    @Test
    fun completableCreate() {
        Completable.create { emitter ->
            if (!emitter.isDisposed) {
                emitter.onComplete()
            }
        }.subscribe(
                { println("--------- completableCreate onComplete ") },
                { println("--------- completableCreate onError") }
        )
    }
}
