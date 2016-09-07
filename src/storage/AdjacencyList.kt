package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyList<T>(val storage: MutableSet<MutableSet<Vertex<T>>>) {
    constructor(): this(mutableSetOf());
    constructor(adjacencyList: AdjacencyList<T>): this(adjacencyList.storage);
}