package storage;

class Vertex<T>(val incomingEdges: MutableList<Edge<T>>,
                val outgoingEdges: MutableList<Edge<T>>,
                var data: T?,
                var visited: Boolean) {
    constructor() : this(null);
    constructor(data: T?) : this(mutableListOf(), mutableListOf(), data, false);
    constructor(vertex: Vertex<T>) : this(vertex.incomingEdges, vertex.outgoingEdges, vertex.data, vertex.visited);
}