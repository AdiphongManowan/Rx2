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

/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class ZipTest {

    //just
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableJust() {
        Flowable<String> flowable1 = Flowable.just("Hello", "World");
        Flowable<String> flowable2 = Flowable.just("Hello", "World", "Android");
        Flowable<Integer> flowable3 = Flowable.just(1, 3, 3, 4);

        Flowable.zip(flowable1,
                flowable2,
                flowable3,
                Triplet::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length() + objects.getValue2()
        ).subscribe(
                s -> System.out.println("---------------flowable  result " + s)
        );
    }

    @Test
    public void observableJust() {
        Observable<String> observable1 = Observable.just("Hello", "World", "android");
        Observable<String> observable2 = Observable.just("Hello", "World");

        Observable.zip(observable1,
                observable2,
                Pair::with
        ).toList().subscribe(
                s -> System.out.println("---------------observable result " + s)
        );

    }

    @Test
    public void maybeJust() {
        // can be only one data
        Maybe<String> maybe1 = Maybe.just("Hello");
        Maybe<String> maybe2 = Maybe.just("Hello");

        Maybe.zip(maybe1,
                maybe2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------maybe result " + s)
        );
    }

    @Test
    public void singleJust() {
        // can be only one data
        Single<String> single1 = Single.just("Hello");
        Single<String> single2 = Single.just("Hello");

        Single.zip(single1,
                single2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------single result " + s)
        );
    }


    //create
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableCreate() {
        Flowable<String> flowable1 = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                if (!e.isCancelled()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onNext("anroid");
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER);

        Flowable<String> flowable2 = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                if (!e.isCancelled()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER);

        Flowable.zip(flowable1,
                flowable2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------flowable  result " + s)
        );
    }

    @Test
    public void observableCreate() {
        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onComplete();
                }
            }
        });

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("hello");
                    e.onNext("world");
                    e.onComplete();
                }
            }
        });

        Observable.zip(observable1,
                observable2,
                Pair::with
        ).toList().subscribe(
                s -> System.out.println("---------------observable result " + s)
        );
    }

    @Test
    public void maybeCreate() {
        // can be only one data
        Maybe<String> maybe1 = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                    e.onComplete();
                }

            }
        });

        Maybe<String> maybe2 = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                    e.onComplete();
                }

            }
        });

        Maybe.zip(maybe1,
                maybe2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------maybe result " + s)
        );
    }

    @Test
    public void singleCreate() {
        // can be only one data
        Single<String> single1 = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                }

            }
        });

        Single<String> single2 = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onSuccess("hello");
                    e.onSuccess("world");
                }

            }
        });

        Single.zip(single1,
                single2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------single result " + s)
        );
    }


    //fromCallAble
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableFromCallable() {
        Flowable<String> flowable1 = Flowable.fromCallable(() -> "hello");
        Flowable<String> flowable2 = Flowable.fromCallable(() -> "hello");

        Flowable.zip(flowable1,
                flowable2,
                Pair::with)
                .map(
                        objects -> objects.getValue0().length() + objects.getValue1().length()
                )
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableFromCallable() {
        Observable<String> observable1 = Observable.fromCallable(() -> "hello");
        Observable<String> observable2 = Observable.fromCallable(() -> "hello");

        Observable.zip(observable1,
                observable2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------observable result " + s)
        );
    }

    @Test
    public void maybeFromCallable() {
        // can be only one data
        Maybe<String> maybe1 = Maybe.fromCallable(() -> "hello");
        Maybe<String> maybe2 = Maybe.fromCallable(() -> "hello");

        Maybe.zip(maybe1,
                maybe2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------maybe result " + s)
        );
    }

    @Test
    public void singleFromCallable() {
        // can be only one data
        Single<String> single1 = Single.fromCallable(() -> "hello");
        Single<String> single2 = Single.fromCallable(() -> "hello");

        Single.zip(single1,
                single2,
                Pair::with
        ).map(
                objects -> objects.getValue0().length() + objects.getValue1().length()
        ).subscribe(
                s -> System.out.println("---------------single result " + s)
        );
    }

}
