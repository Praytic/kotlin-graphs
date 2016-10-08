package algorithm

import storage.Vertex

internal class FindAllPaths<T>(val from: Vertex<T>, val to: Vertex<T>):
        Algorithm<Set<Vertex<T>>>(emptySet<Vertex<T>>()) {

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