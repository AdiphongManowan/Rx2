package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class CompositeDisposableTest {
    CompositeDisposable disposable = new CompositeDisposable();

    //just
    //////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableJust() {
        disposable.add(Flowable
                .just("Hello", "World")
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                )
        );
    }

    @Test
    public void observableJust() {
        disposable.add(Observable
                .just("Hello", "World")
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                )
        );
    }

    @Test
    public void maybeJust() {
        // can be only one data
        disposable.add(Maybe.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                )
        );
    }

    @Test
    public void singleJust() {
        // can be only one data
        disposable.add(Single.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                )
        );
    }

    @Test
    public void completeAbleJust() {
        //can be only one data
        disposable.add(Completable.create(emitter -> {
                    emitter.onComplete();
                })
                        .subscribe(
                                () -> System.out.println("--------- completableCreate onComplete "),
                                throwable -> System.out.println("--------- completableCreate onError")
                        )
        );
    }

}
