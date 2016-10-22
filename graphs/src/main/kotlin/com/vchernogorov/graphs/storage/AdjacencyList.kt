package com.vchernogorov.graphs.storage

class AdjacencyList<T>(val storage: MutableMap<T, MutableMap<T, Number?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyList: AdjacencyList<T>): this(adjacencyList.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.vertices) {
            val mutableRow = mutableMapOf<T, Number?>()
            for (j in graph.getOutgoingEdges(i)) {
                mutableRow.put(j.to.data, j.cost)
            }
            storage.put(i.data, mutableRow)
        }
    }
}