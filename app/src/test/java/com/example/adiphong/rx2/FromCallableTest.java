package com.example.adiphong.rx2;

import org.junit.Test;

import java.util.Arrays;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class FromCallableTest {

// String
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void flowableFromCallable() {
        Flowable.fromCallable(
                () -> "hello")
                .subscribe(
                        s -> System.out.println("------- flowableFromCallable " + s)
                );
    }

    @Test
    public void observableFromCallable() {
        Observable.fromCallable(
                () -> "hello")
                .subscribe(
                        s -> System.out.println("------- ObservableFromCallable " + s)
                );
    }

    @Test
    public void maybeFromCallable() {
        Maybe.fromCallable(
                () -> "hello")
                .subscribe(
                        s -> System.out.println("------- MaybeFromCallable " + s)
                );
    }

    @Test
    public void singleFromCallable() {
        Single.fromCallable(
                () -> "hello")
                .subscribe(
                        s -> System.out.println("------- SingleFromCallable " + s)
                );
    }

    @Test
    public void completableFromCallable() {
        // ignore result
        Completable.fromCallable(
                () -> "hello")
                .subscribe(() -> System.out.println("------- completableFromCallable ignore result")
                );
    }

    // Integer
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void intObservableFromCallable() {
        Observable.fromCallable(
                () -> {
                    int test = 0;
                    return test / 0;
                })
                .subscribe(
                        s -> System.out.println("------- intObservableFromCallable " + s),
                        throwable -> System.out.println("------- intObservableFromCallable onError ")
                );
    }


    // List
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void listObservableFromCallable() {
        Observable.fromCallable(
                () -> Arrays.asList("hello", "world"))
                .subscribe(
                        s -> System.out.println("------- listObservableFromCallable " + s)
                );
    }
}
