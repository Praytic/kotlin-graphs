package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyList<T>(val storage: Map<T, Map<T, Number>>) {
    constructor(): this(emptyMap())
    constructor(adjacencyList: AdjacencyList<T>): this(adjacencyList.storage)
}