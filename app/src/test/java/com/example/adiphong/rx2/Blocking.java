package com.example.adiphong.rx2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class Blocking {


    @Test
    public void blockingIterable() {
        Iterable<Integer> integers = Observable.fromArray("Hello", "World")
                .map(s -> s.length())
                .blockingIterable();
        System.out.println("--------- integer"+integers);
    }

    @Test
    public void blockingGet() {
        Integer integer = Observable.fromIterable(Arrays.asList("Hello", "World"))
                .toList()
                .map(List::size)
                .blockingGet();
        System.out.println("--------- integer"+integer);
    }

}
