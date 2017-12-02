package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class fromArrayTest {

    String[] testArray = {"hello", "world"};

    @Test
    public void flowableJust() {
        Flowable.fromArray(testArray)
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.fromArray(testArray)
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );

    }
}
