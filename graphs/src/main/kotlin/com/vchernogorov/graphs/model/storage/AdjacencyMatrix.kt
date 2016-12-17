package com.vchernogorov.graphs.model.storage

import com.vchernogorov.graphs.algorithm.INF
import com.vchernogorov.graphs.model.Graph
import com.vchernogorov.graphs.model.Vertex

open class AdjacencyMatrix<T>(override val storage: MutableMap<Vertex<T>, MutableMap<Vertex<T>, Int?>>) :
        Storage<MutableMap<Vertex<T>, MutableMap<Vertex<T>, Int?>>> {
    constructor(): this(mutableMapOf())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.vertices) {
            val mutableRow = mutableMapOf<Vertex<T>, Int?>()
            mutableRow.put(i, 0)
            for (j in graph[i]) {
                mutableRow.put(j.to, j.cost)
            }
            storage.put(i, mutableRow)
        }
    }

    val incidenceMatrix: IncidenceMatrix by lazy {
        val matrix = IncidenceMatrix(this.storage.size)
        var i = 0
        for (row in this.storage.values) {
            var j = 0
            for (value in row.values) {
                if (value != null) matrix[i, j++] = 1
            }
            i++
        }
        matrix
    }

    operator fun get(i: Vertex<T>, j: Vertex<T>) = storage.get(i)?.get(j) ?: INF
    operator fun set(i: Vertex<T>, j: Vertex<T>, value: Int) = storage.get(i)?.set(j, value)
}