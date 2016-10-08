package algorithm

import storage.Graph

internal class AreIsomorphicAlgorithm<T>(val graph1: Graph<T>, val graph2: Graph<T>, var result: Boolean = false):
        Runnable {

    override fun run() {
        if (graph1 === graph2) {
            result = true
        }
        else if (graph1.verticies.size == 0 && graph1.verticies.size == 0) {
            result =  true
        }
        else if (graph1.verticies.size == graph2.verticies.size &&
                graph1.edges.size == 0 && graph2.edges.size == 0) {
            result = true
        }
        else if (graph1.verticies.size != graph2.verticies.size) {
            result = false
        }
        else if (graph1.edges.size != graph2.edges.size) {
            result = false
        }
        else {
            areIsomorphic(graph1, graph2)
        }
    }

    fun areIsomorphic(graph1: Graph<T>, graph2: Graph<T>) {
        // TODO: Implement
    }
}