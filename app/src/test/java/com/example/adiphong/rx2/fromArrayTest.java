package com.example.adiphong.rx2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

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
