package com.example.adiphong.rx2

import io.reactivex.*
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class FromCallableTest {

    // String
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    fun flowableFromCallable() {
        Flowable.fromCallable {
            "hello"
        }.subscribe { s ->
            println("------- flowableFromCallable $s")
        }
    }

    @Test
    fun observableFromCallable() {
        Observable.fromCallable {
            "hello"
        }.subscribe { s ->
            println("------- ObservableFromCallable $s")
        }
    }

    @Test
    fun maybeFromCallable() {
        Maybe.fromCallable {
            "hello"
        }.subscribe { s ->
            println("------- MaybeFromCallable $s")
        }
    }

    @Test
    fun singleFromCallable() {
        Single.fromCallable {
            "hello"
        }.subscribe { s ->
            println("------- SingleFromCallable $s")
        }
    }

    @Test
    fun completableFromCallable() {
        // ignore result
        Completable.fromCallable {
            "hello"
        }.subscribe {
            println("------- completableFromCallable ignore result")
        }
    }

    // Integer
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun intObservableFromCallable() {
        Observable.fromCallable {
            val test = 0
            test / 0
        }.subscribe(
                { s -> println("------- intObservableFromCallable " + s!!) },
                { throwable -> println("------- intObservableFromCallable onError ") }
        )
    }

    // List
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun listObservableFromCallable() {
        Observable.fromCallable {
            listOf("hello", "world")
        }.subscribe { s ->
            println("------- listObservableFromCallable $s")
        }
    }
}
