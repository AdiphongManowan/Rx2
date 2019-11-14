package com.example.adiphong.rx2

import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.Test

/**
 * Created by adiphong on 27/11/2017 AD.
 */

class FromActionTest {

    @Test
    fun maybeFromAction() {
        Maybe.fromAction<Any> { println("-------- from action") }
                .subscribe(
                        { s -> println("------- maybeFromAction onSuccess $s") },
                        { throwable -> println("---------- maybeFromAction error") },
                        { println("-------------- maybeFromAction onComplete ") }
                )
    }

    @Test
    fun completableFromAction() {
        // ignore result
        Completable.fromCallable { "hello" }
                .subscribe(
                        { println("-------------- completableFromAction onComplete") },
                        { throwable -> println("-------- completableFromAction onError") }
                )
    }
}
