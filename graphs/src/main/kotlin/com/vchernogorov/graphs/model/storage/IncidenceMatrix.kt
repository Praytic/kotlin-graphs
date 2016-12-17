package com.vchernogorov.graphs.model.storage

class IncidenceMatrix(override val storage: Array<IntArray>) : Storage<Array<IntArray>> {
    constructor(size: Int) : this(Array<IntArray>(size, { IntArray(size) }))

    operator fun get(i: Int) = storage.get(i)
    operator fun get(i: Int, j: Int) = storage.get(i).get(j)
    operator fun set(i: Int, j: Int, value: Int) = storage.get(i).set(j, value)
}