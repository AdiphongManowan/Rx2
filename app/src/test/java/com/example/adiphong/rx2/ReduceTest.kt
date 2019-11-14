package com.example.adiphong.rx2

import io.reactivex.*
import org.junit.Test

/**
 * Created by adiphong on 28/11/2017 AD.
 */

class ReduceTest {

    //just
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableJust() {
        val flowable = Flowable.just(1, 3, 3, 4)

        flowable.reduce { integer, integer2 ->
            integer + integer2
        }.subscribe { s ->
            println("---------------flowable  result " + s!!)
        }
    }

    @Test
    fun observableJust() {
        val observable = Observable.just(1, 3, 3, 4)

        observable.reduce { integer, integer2 ->
            integer + integer2
        }.subscribe { s ->
            println("---------------observable result " + s!!)
        }

    }

    //create
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableCreate() {
        val flowable = Flowable.create(FlowableOnSubscribe<Int> { e ->
            if (!e.isCancelled) {
                e.onNext(1)
                e.onNext(3)
                e.onNext(3)
                e.onNext(4)
                e.onComplete()
            }
        }, BackpressureStrategy.BUFFER)

        flowable.reduce { integer, integer2 ->
            integer + integer2
        }.subscribe { s ->
            println("---------------flowable  result " + s!!)
        }
    }

    @Test
    fun observableCreate() {
        val observable = Observable.create(ObservableOnSubscribe<Int> { e ->
            if (!e.isDisposed) {
                e.onNext(1)
                e.onNext(3)
                e.onNext(3)
                e.onNext(4)
                e.onComplete()
            }
        })

        observable.reduce { integer, integer2 ->
            integer + integer2
        }.subscribe { s ->
            println("---------------observable result " + s!!)
        }
    }
}
