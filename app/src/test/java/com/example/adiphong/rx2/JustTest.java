package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class JustTest {

    @Test
    public void flowableJust() {
        Flowable.just("Hello", "World")
                .subscribe(
                        s -> System.out.println("---------------flowable  result " + s)
                );
    }

    @Test
    public void observableJust() {
        Observable.just("Hello", "World")
                .subscribe(new Observer<String>() {
                               @Override
                               public void onSubscribe(Disposable d) {
                                   d.dispose();
                               }

                               @Override
                               public void onNext(String s) {
                                   System.out.println("------- "+s);
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }

    @Test
    public void maybeJust() {
        // can be only one UserData
        Maybe.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------maybe result " + s)
                );
    }

    @Test
    public void singleJust() {
        // can be only one UserData
        Single.just("Hello")
                .subscribe(
                        s -> System.out.println("---------------single result " + s)
                );
    }

    @Test
    public void testIfObserveAble(){
        Observable
                .just(1,2,3,4,5,6,7,8,9)
                .subscribe(integer -> System.out.println("------- result "+integer));

    }
}
