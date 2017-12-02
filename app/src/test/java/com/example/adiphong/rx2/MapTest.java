package com.example.adiphong.rx2;

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


/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class MapTest {

    //just
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableJust() {
        Flowable.just("Hello", "World")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeJust() {
        // can be only one data
        Maybe.just("Hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleJust() {
        // can be only one data
        Single.just("Hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }


    //create
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableCreate() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                if (!e.isCancelled()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER)
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableCreate() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onComplete();
                }
            }
        })
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeCreate() {
        // can be only one data
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                    e.onComplete();
                }

            }
        }).map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleCreate() {
        // can be only one data
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                }

            }
        }).map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }


    //fromCallAble
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableFromCallable() {
        Flowable.fromCallable(() -> "hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableFromCallable() {
        Observable.fromCallable(() -> "hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeFromCallable() {
        // can be only one data
        Maybe.fromCallable(() -> "hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleFromCallable() {
        // can be only one data
        Single.fromCallable(() -> "hello")
                .map(s -> s.length())
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }

}
