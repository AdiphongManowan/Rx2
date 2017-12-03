package com.example.adiphong.rx2;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Test;

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
import io.reactivex.functions.BiFunction;

/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class ReduceTest {

    //just
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableJust() {
        Flowable<Integer> flowable = Flowable.just(1, 3, 3, 4);

        flowable.reduce(
                (integer, integer2) -> integer + integer2
        ).subscribe(
                s -> System.out.println("---------------flowable  result " + s)
        );
    }

    @Test
    public void observableJust() {
        Observable<Integer> observable = Observable.just(1, 3, 3, 4);

        observable.reduce(
                (integer, integer2) -> integer + integer2
        ).subscribe(
                s -> System.out.println("---------------observable result " + s)
        );

    }

    //create
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableCreate() {
        Flowable<Integer> flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                if (!e.isCancelled()) {
                    e.onNext(1);
                    e.onNext(3);
                    e.onNext(3);
                    e.onNext(4);
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER);



        flowable.reduce(
                (integer, integer2) -> integer + integer2
        ).subscribe(
                s -> System.out.println("---------------flowable  result " + s)
        );
    }

    @Test
    public void observableCreate() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    e.onNext(3);
                    e.onNext(3);
                    e.onNext(4);
                    e.onComplete();
                }
            }
        });

        observable.reduce(
                (integer, integer2) -> integer + integer2
        ).subscribe(
                s -> System.out.println("---------------observable result " + s)
        );
    }
}
