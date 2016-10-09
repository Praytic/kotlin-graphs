package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class AreIsomorphic<T, R>(val graph1: Graph<T>, val graph2: Graph<R>):
        Algorithm<Boolean>(true) {

    override fun run() {
        if (graph1 === graph2) {
            result = true
        }
        else if (graph1.vertices.size == 0 && graph2.vertices.size == 0) {
            result = true
        }
        else if (graph1.vertices.size == graph2.vertices.size &&
                graph1.edges.size == 0 && graph2.edges.size == 0) {
            result = true
        }
        else if (graph1.vertices.size != graph2.vertices.size) {
            result = false
        }
        else if (graph1.edges.size != graph2.edges.size) {
            result = false
        }
        else {
            areIsomorphic(graph1, graph2)
        }
    }

    fun areIsomorphic(graph1: Graph<T>, graph2: Graph<R>) {
        // TODO: Implement
    }
}