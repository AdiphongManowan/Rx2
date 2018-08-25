package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Observable;

public class Concat {

    @Test
    public void concatCreate() {
        int input = 0;
        Observable.create(emitter -> {
                    if (!emitter.isDisposed()) {
                        int result = 1;
//                        result /= input;

                        emitter.onNext(result);
                        emitter.onComplete();
                    }
                }
        );

//        Observable<String> observable2 = Observable.create(emitter -> {
//            if (!emitter.isDisposed()) {
//                int result = 2;
////                result /= input;
//                emitter.onNext(""+result);
//                emitter.onComplete();
//            }
//        });
//
//        Observable.concat(observable1, observable2)
//                .doOnError(throwable -> System.out.println("--------- doOnError"))
//                .onErrorResumeNext(Observable.never())
//                .subscribe(
//                        s -> System.out.println("-------------- on next "+s),
//                        throwable -> System.out.println("----------- error "+throwable),
//                        () -> System.out.println("----------- on complete")
//                );
    }
}
