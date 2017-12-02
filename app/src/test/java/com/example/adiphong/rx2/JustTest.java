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
        Flowable.just("Hello", "World")
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeJust() {
        // can be only one data
        Maybe.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleJust() {
        // can be only one data
        Single.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }
}
