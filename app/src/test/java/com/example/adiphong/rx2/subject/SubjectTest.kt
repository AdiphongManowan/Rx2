package com.example.adiphong.rx2.subject

import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import org.junit.Test

class SubjectTest {

    @Test
    fun publishSubjectTest() {
        val source: PublishSubject<Int> = PublishSubject.create()
        // subscribe with FirstObserver
        source.subscribe { println("FirstObserver onNext: $it") }

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        // subscribe with SecondObserver
        source.subscribe { println("SecondObserver onNext: $it") }
        source.onNext(4)
        source.onComplete()

        // OUTPUT:
        /**
        FirstObserver onNext: 1
        FirstObserver onNext: 2
        FirstObserver onNext: 3
        FirstObserver onNext: 4
        SecondObserver onNext: 4
         */
    }

    @Test
    fun behaviorSubjectTest() {
        val source: BehaviorSubject<Int> = BehaviorSubject.create()
        // subscribe with FirstObserver
        source.subscribe { println("FirstObserver onNext: $it") }

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        // subscribe with SecondObserver
        source.subscribe { println("SecondObserver onNext: $it") }
        source.onNext(4)
        source.onComplete()

        // OUTPUT:
        /**
        FirstObserver onNext: 1
        FirstObserver onNext: 2
        FirstObserver onNext: 3
        SecondObserver onNext: 3
        FirstObserver onNext: 4
        SecondObserver onNext: 4
         **/
    }

    @Test
    fun replaySubjectTest() {
        val source: ReplaySubject<Int> = ReplaySubject.create()
        // subscribe with FirstObserver
        source.subscribe { println("FirstObserver onNext: $it") }

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        // subscribe with SecondObserver
        source.subscribe { println("SecondObserver onNext: $it") }
        source.onNext(4)
        source.onComplete()

        // OUTPUT:
        /**
        FirstObserver onNext: 1
        FirstObserver onNext: 2
        FirstObserver onNext: 3
        SecondObserver onNext: 1
        SecondObserver onNext: 2
        SecondObserver onNext: 3
        FirstObserver onNext: 4
        SecondObserver onNext: 4
        **/
    }

    @Test
    fun asyncSubjectTest() {
        val source: AsyncSubject<Int> = AsyncSubject.create()
        // subscribe with FirstObserver
        source.subscribe { println("FirstObserver onNext: $it") }

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        // subscribe with SecondObserver
        source.subscribe { println("SecondObserver onNext: $it") }
        source.onNext(4)
        source.onComplete()

        // OUTPUT:
        /**
        FirstObserver onNext: 4
        SecondObserver onNext: 4
         **/
    }
}
