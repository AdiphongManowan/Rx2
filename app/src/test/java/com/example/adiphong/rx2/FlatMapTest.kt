package com.example.adiphong.rx2

import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.functions.Function
import org.junit.Test
import org.reactivestreams.Publisher
import java.util.*

/**
 * Created by adiphong on 28/11/2017 AD.
 */

class FlatMapTest {
    private val number: Int = 0

    //    private List<Integer> numberList = new ArrayList<>();

    @Test
    fun testGG() {
        println("----------- " + testNumberGG(100))

    }

    private fun testNumberGG(number: Int): List<Int> {
        val numberString = number.toString()
        val numberList = ArrayList<Int>()
        for (element in numberString) {
            numberList.add(Integer.parseInt(element.toString()))
        }

        return numberList
    }

    //just
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableJust() {
        Flowable.just("Hello", "World")
                .flatMap { s -> Flowable.just(s.length) }
                .subscribe { s -> println("---------------flowable  result " + s!!) }
    }

    @Test
    fun observableJust() {
        Observable.just("Hello", "World")
                .flatMap { s -> Observable.just(s.length) }
                .subscribe { s -> println("---------------observable result " + s!!) }
    }

    @Test
    fun maybeJust() {
        // can be only one data
        Maybe.just("Hello")
                .flatMap { s -> Maybe.just(s.length) }
                .subscribe { s -> println("---------------maybe result " + s!!) }
    }

    @Test
    fun singleJust() {
        // can be only one data
        Single.just("Hello")
                .flatMap { s -> Single.just(s.length) }
                .subscribe { s -> println("---------------single result " + s!!) }
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
        }, BackpressureStrategy.BUFFER
        ).flatMap(Function<String, Publisher<Int>> { s ->
            Flowable.create({ e ->
                if (!e.isCancelled) {
                    e.onNext(s.length)
                    e.onComplete()
                }
            }, BackpressureStrategy.BUFFER)
        }).subscribe { s -> println("---------------flowable  result " + s!!) }
    }

    @Test
    fun observableCreate() {
        Observable.create(ObservableOnSubscribe<String> { e ->
            if (!e.isDisposed) {
                e.onNext("hello")
                e.onNext("world")
                e.onComplete()
            }
        }).flatMap(Function<String, ObservableSource<Int>> { s ->
            Observable.create { e ->
                if (!e.isDisposed) {
                    e.onNext(s.length)
                    e.onComplete()
                }
            }
        }).subscribe { s -> println("---------------observable result " + s!!) }
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
        }).flatMap(Function<String, MaybeSource<Int>> { s ->
            Maybe.create { e ->
                if (!e.isDisposed) {
                    e.onSuccess(s.length)
                    e.onComplete()
                }
            }
        }).subscribe { s -> println("---------------maybe result " + s!!) }
    }

    @Test
    fun singleCreate() {
        // can be only one data
        Single.create(SingleOnSubscribe<String> { e ->
            if (!e.isDisposed) {
                e.onSuccess("hello")
                e.onSuccess("world")
            }
        }).flatMap(Function<String, SingleSource<Int>> { s ->
            Single.create { e ->
                if (!e.isDisposed) {
                    e.onSuccess(s.length)
                }
            }
        }).subscribe { s -> println("---------------single result " + s!!) }
    }


    //fromCallAble
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    fun flowableFromCallable() {
        Flowable.fromCallable { "hello" }
                .flatMap { s -> Flowable.fromCallable { s.length } }
                .subscribe { s -> println("---------------flowable  result " + s!!) }
    }

    @Test
    fun observableFromCallable() {
        Observable.fromCallable { "hello" }
                .flatMap { s -> Observable.fromCallable { s.length } }
                .subscribe { s -> println("---------------observable result " + s!!) }
    }

    @Test
    fun maybeFromCallable() {
        // can be only one data
        Maybe.fromCallable { "hello" }
                .flatMap { s -> Maybe.fromCallable { s.length } }
                .subscribe { s -> println("---------------maybe result " + s!!) }
    }

    @Test
    fun singleFromCallable() {
        // can be only one data
        Single.fromCallable { "hello" }
                .flatMap { s -> Single.fromCallable { s.length } }
                .subscribe { s -> println("---------------single result " + s!!) }
    }


    @Test
    fun createWithFatmap() {
        val input = 0
        Observable.create<Any> { emitter ->
            if (!emitter.isDisposed) {
                val result = 1
                //                        result /= input;

                emitter.onNext(result)
                emitter.onComplete()
            }
        }.doOnError { println("--------- doOnError") }.onErrorResumeNext(
                Observable.never()
        ).flatMap {
            Observable.error<Any>(Exception())
            //            return Observable.just(1);
        }.subscribe(
                { integer -> println("------------ on next $integer") },
                { throwable -> println("-------- on error $throwable") },
                { println("---------- on complete") }
        )

    }
}