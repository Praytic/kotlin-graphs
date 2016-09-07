package storage;

class Edge<T>(val from: Vertex<T>,
              val to: Vertex<T>,
              var cost: Number?,
              var visited: Boolean) {
    constructor(from: Vertex<T>, to: Vertex<T>): this(from, to, 0, false)
    constructor(from: Vertex<T>, to: Vertex<T>, cost: Int): this(from, to, cost, false)
    constructor(edge: Edge<T>): this(edge.from, edge.to, edge.cost, edge.visited)

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Edge<*>

        if (from != other.from) return false
        if (to != other.to) return false

        return true
    }

    override fun hashCode(): Int{
        var result = from.hashCode()
        result = 31 * result + to.hashCode()
        return result
    }
}