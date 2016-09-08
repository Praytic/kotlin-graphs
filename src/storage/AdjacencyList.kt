package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyList<T>(val storage: MutableMap<T, MutableMap<T, Number?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyList: AdjacencyList<T>): this(adjacencyList.storage)
}