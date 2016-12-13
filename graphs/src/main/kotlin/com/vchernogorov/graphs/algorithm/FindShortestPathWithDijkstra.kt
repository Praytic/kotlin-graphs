package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindShortestPathWithDijkstra<T>(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>)
    : FindShortestPaths<T>(graph, from, to) {

    override fun findShortestPath() {
        val search = DijkstraSearch(graph, from)
        search.onFindShortestPathForVertex = { vertex, edge -> if (edge.to == to) result.add(edge) }
        search.run()
    }
}
