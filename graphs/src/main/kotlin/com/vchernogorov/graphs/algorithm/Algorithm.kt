package com.vchernogorov.graphs.algorithm

internal abstract class Algorithm<T> : Runnable {
    abstract var result: T
}