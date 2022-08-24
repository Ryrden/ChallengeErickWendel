package com.challenge;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionExecuter {

    public static <T, R> Timer<R> getFunctionTimer(T input, Function<T, R> function) {
        var startingTime = System.nanoTime();
        var fuctionResult = function.apply(input);
        return new Timer<>(fuctionResult, System.nanoTime() - startingTime);
    }

    public static <T, R> Timer<R> getFunctionTimer(Supplier<R> function) {
        var startingTime = System.nanoTime();
        function.get();
        return new Timer<>(null, System.nanoTime() - startingTime);
    }
}

record Timer<T> (T result, long timestamp) {
}
