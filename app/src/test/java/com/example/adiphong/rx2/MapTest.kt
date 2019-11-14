package com.example.adiphong.rx2

import io.reactivex.*
import org.junit.Test

/**
 * Created by adiphong on 28/11/2017 AD.
 */

class MapTest {

    //just
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableJust() {
        Flowable.just(
                "Hello", "World"
        ).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------flowable  result " + s!!)
        }
    }

    @Test
    fun observableJust() {
        Observable.just(
                "Hello", "World"
        ).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------observable result " + s!!)
        }
    }

    @Test
    fun maybeJust() {
        // can be only one data
        Maybe.just(
                "Hello"
        ).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------maybe result " + s!!)
        }
    }

    @Test
    fun singleJust() {
        // can be only one data
        Single.just(
                "Hello"
        ).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------single result " + s!!)
        }
    }


    //create
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableCreate() {
        Flowable.create(FlowableOnSubscribe<String> { e ->
            if (!e.isCancelled) {
                e.onNext("hello")
                e.onNext("world")
                e.onComplete()
            }
        },
                BackpressureStrategy.BUFFER
        ).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------flowable  result " + s!!)
        }
    }

    @Test
    fun observableCreate() {
        Observable.create(ObservableOnSubscribe<String> { e ->
            if (!e.isDisposed) {
                e.onNext("hello")
                e.onNext("world")
                e.onComplete()
            }
        }).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------observable result " + s!!)
        }
    }

    @Test
    fun maybeCreate() {
        // can be only one data
        Maybe.create(MaybeOnSubscribe<String> { e ->
            if (!e.isDisposed) {
                e.onSuccess("hello")
                e.onSuccess("world")
                e.onComplete()
            }
        }).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------maybe result " + s!!)
        }
    }

    @Test
    fun singleCreate() {
        // can be only one data
        Single.create(SingleOnSubscribe<String> { e ->
            if (!e.isDisposed) {
                e.onSuccess("hello")
                e.onSuccess("world")
            }
        }).map { s ->
            s.length
        }.subscribe { s ->
            println("---------------single result " + s!!)
        }
    }


    //fromCallAble
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableFromCallable() {
        Flowable.fromCallable { "hello" }
                .map { s -> s.length }
                .subscribe { s -> println("---------------flowable  result " + s!!) }
    }

    @Test
    fun observableFromCallable() {
        Observable.fromCallable { "hello" }
                .map { s -> s.length }
                .subscribe { s -> println("---------------observable result " + s!!) }
    }

    @Test
    fun maybeFromCallable() {
        // can be only one data
        Maybe.fromCallable { "hello" }
                .map { s -> s.length }
                .subscribe { s -> println("---------------maybe result " + s!!) }
    }

    @Test
    fun singleFromCallable() {
        // can be only one data
        Single.fromCallable { "hello" }
                .map { s -> s.length }
                .subscribe { s -> println("---------------single result " + s!!) }
    }

}
