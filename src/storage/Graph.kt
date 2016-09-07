package storage

/**
 * Created by vchernogorov on 06/09/16.
 */
class Graph<T>(val verticies: MutableMap<T, Vertex<T>>,
               val edges: MutableSet<Edge<T>>) {
    constructor() : this(mutableMapOf(), mutableSetOf());
    constructor(graph: Graph<T>) : this(graph.verticies, graph.edges);
}