package com.vchernogorov.graphs.model.storage

import com.vchernogorov.graphs.model.Edge

open class Path<T>(override val storage: MutableSet<Edge<T>> = mutableSetOf()) : Storage<Set<Edge<T>>> {
    constructor(path: Path<T>) : this(path.storage)
}