package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyMatrix<T>(val storage: MutableMap<T, MutableMap<T, Number?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
}