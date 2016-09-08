package storage

/**
 * Created by vchernogorov on 06/09/16.
 */
class Graph<T>(val verticies: MutableSet<Vertex<T>>,
               val edges: MutableSet<Edge<T>>) {
    constructor(): this(mutableSetOf(), mutableSetOf())
    constructor(graph: Graph<T>): this(graph.verticies, graph.edges)

    fun getAsAdjacencyMatrix(): AdjacencyMatrix<T> {
        val mutableColumn = mutableMapOf<T, MutableMap<T, Number?>>()
        for (i in verticies) {
            val mutableRow = mutableMapOf<T, Number?>()
            for (j in verticies) {
                val edge = (edges.find { x -> x.to == j } ?: Edge(i, j, 0))
                mutableRow.put(edge.to.data, edge.cost)
            }
            mutableColumn.put(i.data, mutableRow)
        }
        return AdjacencyMatrix<T>(mutableColumn)
    }

    fun isIsomorphic(graph: Graph<T>): Boolean {
        if (graph === this) return true
        if (graph.verticies.size != this.verticies.size) return false
        if (graph.edges.size != this.edges.size) return false

        val adjacencyMatrix = graph.getAsAdjacencyMatrix()

        return true
    }
}