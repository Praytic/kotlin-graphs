package com.vchernogorov.graphs.storage;

class Vertex<T>(var data: T) {
    constructor(vertex: Vertex<T>): this(vertex.data)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Vertex<*>

        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        return data?.hashCode() ?: 0
    }
}