package com.example.adiphong.rx2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class fromIterableTest {

    List<String> testList = Arrays.asList("hello", "world");

    @Test
    public void flowableJust() {
        Flowable.fromIterable(testList)
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.fromIterable(testList)
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }
}
