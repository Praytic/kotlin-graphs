package algorithm

import storage.Vertex

internal class FindAllPathsAlgorithm<T>(val from: Vertex<T>, val to: Vertex<T>,
                                        val result: Set<Vertex<T>> = emptySet<Vertex<T>>()): Runnable {

    override fun run() {
        if (havePath()) {
            findAllPaths()
        }
    }

    fun havePath(): Boolean {
        return from.outgoingEdges.isNotEmpty() && to.incomingEdges.isNotEmpty() && !from.equals(to);
    }

    fun findAllPaths() {
        // TODO: Implement
    }
}