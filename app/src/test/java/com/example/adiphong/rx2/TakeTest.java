package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class TakeTest {

    @Test
    public void flowableJust() {
        Flowable.just("Hello", "World")
                .take(1)
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .take(1)
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }
}
