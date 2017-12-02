package com.example.adiphong.rx2;

import org.junit.Test;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class FromActionTest {

    @Test
    public void maybeFromAction() {
        Maybe.fromAction(() -> System.out.println("-------- from action"))
                .subscribe(
                        s -> System.out.println("------- maybeFromAction onSuccess " + s),
                        throwable -> System.out.println("---------- maybeFromAction error"),
                        () -> System.out.println("-------------- maybeFromAction onComplete ")
                );
    }

    @Test
    public void completableFromAction() {
        // ignore result
        Completable.fromCallable(
                () -> "hello")
                .subscribe(
                        () -> System.out.println("-------------- completableFromAction onComplete"),
                        throwable -> System.out.println("-------- completableFromAction onError")
                );
    }
}
