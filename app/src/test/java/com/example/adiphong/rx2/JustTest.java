package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class JustTest {

    @Test
    public void flowableJust() {
        Flowable<String> flowable = Flowable.just("Hello", "World");
        flowable.subscribe(
                s -> System.out.println("---------------flowable  result " + s)
        );
    }

    @Test
    public void observableJust() {
        Observable<String> observable = Observable.just("Hello", "World");
        observable.subscribe(
                s -> System.out.println("---------------observable result " + s)
        );
    }

    @Test
    public void maybeJust() {
        Maybe<String> maybe = Maybe.just("Hello");// can be only one data
        maybe.subscribe(
                s -> System.out.println("---------------maybe result " + s)
        );
    }

    @Test
    public void singleJust() {
        Single<String> single = Single.just("Hello");// can be only one data
        single.subscribe(
                s -> System.out.println("---------------single result " + s)
        );
    }
}
