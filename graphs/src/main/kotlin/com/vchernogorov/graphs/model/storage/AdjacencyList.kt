package com.vchernogorov.graphs.model.storage

import com.vchernogorov.graphs.model.Graph

class AdjacencyList<T>(override val storage: MutableMap<T, MutableMap<T, Number?>>) :
        Storage<MutableMap<T, MutableMap<T, Number?>>> {
    constructor(): this(mutableMapOf())
    constructor(adjacencyList: AdjacencyList<T>): this(adjacencyList.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.vertices) {
            val mutableRow = mutableMapOf<T, Number?>()
            for (j in graph[i]) {
                mutableRow.put(j.to.data, j.cost)
            }
            storage.put(i.data, mutableRow)
        }
    }
}