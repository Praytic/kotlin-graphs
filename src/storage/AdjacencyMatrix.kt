package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyMatrix<T>(val storage: Map<T, Map<T, Number>>) {
    constructor(): this(emptyMap())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
}