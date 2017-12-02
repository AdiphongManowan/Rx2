package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class RetryTest {

    @Test
    public void flowableJust() {
        Flowable.just(1, 0, 2)
                .map(integer -> 5/integer)
                .retry(1)
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just(1, 0, 2)
                .map(integer -> 5/integer)
                .retry(1)
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeJust() {
        // can be only one data
        Maybe.just(1)
                .map(integer -> 5/integer)
                .retry(1)
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleJust() {
        // can be only one data
        Single.just(1)
                .map(integer -> 5/integer)
                .retry(1)
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }
}
