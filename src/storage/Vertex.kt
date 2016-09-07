package storage;

class Vertex<T>(val incomingEdges: MutableList<Edge<T>>,
                val outgoingEdges: MutableList<Edge<T>>,
                var data: T,
                var visited: Boolean) {
    constructor(data: T): this(mutableListOf(), mutableListOf(), data, false)
    constructor(vertex: Vertex<T>): this(vertex.incomingEdges, vertex.outgoingEdges, vertex.data, vertex.visited)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Vertex<*>

        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        return data?.hashCode() ?: 0
    }
}