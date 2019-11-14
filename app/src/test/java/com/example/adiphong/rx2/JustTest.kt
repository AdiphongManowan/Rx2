package com.example.adiphong.rx2

import io.reactivex.*
import io.reactivex.disposables.Disposable
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class JustTest {

    @Test
    fun flowableJust() {
        Flowable.just(
                "Hello", "World"
        ).subscribe { s ->
            println("---------------flowable  result $s")
        }
    }

    @Test
    fun observableJust() {
        Observable.just(
                "Hello", "World"
        ).subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                d.dispose()
            }

            override fun onNext(s: String) {
                println("------- $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }
        })
    }

    @Test
    fun maybeJust() {
        // can be only one UserData
        Maybe.just(
                "Hello"
        ).subscribe { s ->
            println("---------------maybe result $s")
        }
    }

    @Test
    fun singleJust() {
        // can be only one UserData
        Single.just(
                "Hello"
        ).subscribe { s ->
            println("---------------single result $s")
        }
    }

    @Test
    fun testIfObserveAble() {
        Observable.just(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        ).subscribe { integer ->
            println("------- result " + integer!!)
        }
    }
}
