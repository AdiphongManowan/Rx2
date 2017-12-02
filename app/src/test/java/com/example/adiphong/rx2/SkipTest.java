package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class SkipTest {

    @Test
    public void flowableJust() {
        Flowable.just("Hello", "World")
                .skip(1)
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .skip(1)
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }
}
