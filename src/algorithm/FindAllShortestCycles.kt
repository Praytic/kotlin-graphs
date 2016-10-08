package algorithm

import storage.Graph
import storage.Vertex

internal class FindAllShortestCycles<T>(val graph: Graph<T>): Algorithm<Set<Set<Vertex<T>>>>(mutableSetOf()) {

    override fun run() {
        throw UnsupportedOperationException()
    }
}