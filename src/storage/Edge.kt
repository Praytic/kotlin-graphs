package storage;

class Edge<T>(val from: Vertex<T>,
              val to: Vertex<T>,
              var cost: Int,
              var visited: Boolean) {
    constructor(from: Vertex<T>, to: Vertex<T>) : this(from, to, 1, false);
    constructor(from: Vertex<T>, to: Vertex<T>, cost: Int) : this(from, to, cost, false);
    constructor(edge: Edge<T>) : this(edge.from, edge.to, edge.cost, edge.visited);
}