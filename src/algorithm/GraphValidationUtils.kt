package algorithm

import storage.Vertex

fun <T> havePath(from: Vertex<T>, to: Vertex<T>): Boolean {
    return from.outgoingEdges.isNotEmpty() && to.incomingEdges.isNotEmpty() && !from.equals(to);
}
