package com.example.adiphong.rx2;

import org.junit.Test;
import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

/**
 * Created by adiphong on 28/11/2017 AD.
 */

public class FlatMapTest {

    //just
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableJust() {
        Flowable.just("Hello", "World")
                .flatMap(s -> Flowable.just(s.length()))
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .flatMap(s -> Observable.just(s.length()))
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeJust() {
        // can be only one data
        Maybe.just("Hello")
                .flatMap(s -> Maybe.just(s.length()))
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleJust() {
        // can be only one data
        Single.just("Hello")
                .flatMap(s -> Single.just(s.length()))
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
                        }, BackpressureStrategy.BUFFER
        ).flatMap(new Function<String, Publisher<Integer>>() {
            @Override
            public Publisher<Integer> apply(String s) throws Exception {
                return Flowable.create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                        if (!e.isCancelled()) {
                            e.onNext(s.length());
                            e.onComplete();
                        }
                    }
                }, BackpressureStrategy.BUFFER);
            }
        }).subscribe(
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
        }).flatMap(new Function<String, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(String s) throws Exception {
                return Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                        if (!e.isDisposed()) {
                            e.onNext(s.length());
                            e.onComplete();
                        }
                    }
                });
            }
        }).subscribe(
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
        }).flatMap(new Function<String, MaybeSource<Integer>>() {
            @Override
            public MaybeSource<Integer> apply(String s) throws Exception {
                return Maybe.create(new MaybeOnSubscribe<Integer>() {
                                        @Override
                                        public void subscribe(MaybeEmitter<Integer> e) throws Exception {
                                            if (!e.isDisposed()) {
                                                e.onSuccess(s.length());
                                                e.onComplete();
                                            }

                                        }
                                    }
                );
            }
        }).subscribe(
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
        }).flatMap(new Function<String, SingleSource<Integer>>() {
            @Override
            public SingleSource<Integer> apply(String s) throws Exception {
                return Single.create(new SingleOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(SingleEmitter<Integer> e) throws Exception {
                        if (!e.isDisposed()) {
                            e.onSuccess(s.length());
                        }

                    }
                });
            }
        }).subscribe(
                s -> System.out.println("---------------single result " + s)
        );
    }


    //fromCallAble
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void flowableFromCallable() {
        Flowable.fromCallable(() -> "hello")
                .flatMap(
                        s -> Flowable.fromCallable(() -> s.length())
                )
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableFromCallable() {
        Observable.fromCallable(() -> "hello")
                .flatMap(
                        s -> Observable.fromCallable(() -> s.length())
                )
                .subscribe(
                        s -> System.out.println("---------------observable result " + s)
                );
    }

    @Test
    public void maybeFromCallable() {
        // can be only one data
        Maybe.fromCallable(() -> "hello")
                .flatMap(
                        s -> Maybe.fromCallable(() -> s.length())
                )
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleFromCallable() {
        // can be only one data
        Single.fromCallable(() -> "hello")
                .flatMap(
                        s -> Single.fromCallable(() -> s.length())
                )
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }

}
