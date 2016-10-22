package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.AdjacencyMatrix
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Permutation

internal class AreIsomorphic<T, R>(val graph1: Graph<T>, val graph2: Graph<R>):
        Algorithm<Boolean>(false) {

    val size = graph1.vertices.size
    val incidenceDoubleArray1 = AdjacencyMatrix(graph1).getIncidenceMatrix()
    val incidenceDoubleArray2 = AdjacencyMatrix(graph2).getIncidenceMatrix()

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
            areIsomorphic(AdjacencyMatrix(graph1), AdjacencyMatrix(graph2))
        }
    }

    fun areIsomorphic(graph1: AdjacencyMatrix<T>, graph2: AdjacencyMatrix<R>) {
        if (graph1 === graph2 ||
            graph1.storage === graph2.storage ||
            graph1.storage.isEmpty() && graph2.storage.isEmpty()) result = true
        if (graph1.storage.size != graph2.storage.size ||
            graph1.storage.values.any { row -> row.size != graph1.storage.size } ||
            graph2.storage.values.any { row -> row.size != graph2.storage.size }) result = false
        val permutation = Permutation(size)
        val incidenceDoubleArray = AdjacencyMatrix(graph2).getIncidenceMatrix()
        while (true) {
            var ready = true
            for (i in 0..size - 1) {
                for (j in 0..size - 1) {
                    if (incidenceDoubleArray[i][j] != incidenceDoubleArray1[i][j]) {
                        ready = false
                        break
                    }
                }
                if (!ready) break
            }
            if (ready) {
                result = true
                return
            }
            if (permutation.last == permutation.current) return
            val perm = permutation.next()
            for (i in 0..size - 1) {
                for (j in 0..size - 1) {
                    incidenceDoubleArray[i][j] = incidenceDoubleArray2[i][perm[j]]
                    incidenceDoubleArray[i][j] = incidenceDoubleArray2[perm[i]][j]
                }
            }
        }
    }
}