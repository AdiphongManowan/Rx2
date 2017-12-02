package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;


/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class CreateTest {

    @Test
    public void flowableCreate() {
        Flowable.create(emitter -> {
            if (!emitter.isCancelled()) {
                emitter.onNext("hello");
                emitter.onNext("world");
                emitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER).subscribe(
                s -> System.out.println("--------- flowableCreate onNext " + s),
                throwable -> System.out.println("--------- flowableCreate onError"),
                () -> System.out.println("--------- flowableCreate onComplete")
        );
    }

    @Test
    public void observableCreate() {
        Observable.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onNext("hello");
                emitter.onNext("world");
                emitter.onComplete();
            }
        }).subscribe(
                s -> System.out.println("--------- observableCreate onNext " + s),
                throwable -> System.out.println("--------- observableCreate onError"),
                () -> System.out.println("--------- observableCreate onComplete")
        );
    }

    @Test
    public void maybeCreate() {
        Maybe.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onSuccess("hello");
                emitter.onSuccess("world");
                emitter.onComplete();
            }
        }).subscribe(
                s -> System.out.println("--------- maybeCreate onNext " + s),
                throwable -> System.out.println("--------- maybeCreate onError"),
                () -> System.out.println("--------- maybeCreate onComplete")
        );
    }

    @Test
    public void singleCreate() {
        Single.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onSuccess("hello");
                emitter.onSuccess("world");
            }
        }).subscribe(
                s -> System.out.println("--------- singleCreate onNext " + s),
                throwable -> System.out.println("--------- singleCreate onError")
        );
    }

    @Test
    public void completableCreate() {
        Completable.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onComplete();
            }
        }).subscribe(
                () -> System.out.println("--------- completableCreate onComplete "),
                throwable -> System.out.println("--------- completableCreate onError")
        );
    }
}
