package storage

/**
 * Created by vchernogorov on 06/09/16.
 */
class Graph<T>(val verticies: MutableSet<Vertex<T>>,
               val edges: MutableSet<Edge<T>>) {
    constructor(): this(mutableSetOf(), mutableSetOf())
    constructor(graph: Graph<T>): this(graph.verticies, graph.edges)
}