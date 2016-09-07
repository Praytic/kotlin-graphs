package storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyMatrix<T>(val storage: Array<Array<T>>) {
    constructor(): this(emptyArray());
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage);
}