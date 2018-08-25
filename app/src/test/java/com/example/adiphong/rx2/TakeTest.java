package com.example.adiphong.rx2;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void observableJust2() {
        Observable.fromIterable(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"))
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
//        Observable.fromArray(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"))
//                .map(strings -> {
//                    System.out.println("---------- ");
//                    return strings.
//                })
//                .take(5)
//                .subscribe(
//                        s -> System.out.println("---------------observable result " + s)
//                );
    }
}
