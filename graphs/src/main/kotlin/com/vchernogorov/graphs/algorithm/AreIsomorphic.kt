package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.AdjacencyMatrix
import com.vchernogorov.graphs.storage.Graph

internal class AreIsomorphic<T, R>(val graph1: Graph<T>, val graph2: Graph<R>):
        Algorithm<Boolean>(false) {

    val incidenceDoubleArray1 = convertToIncidenceDoubleArray(AdjacencyMatrix(graph1))
    val incidenceDoubleArray2 = convertToIncidenceDoubleArray(AdjacencyMatrix(graph2))

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
        var sfa = IntArray(23)

    }

    fun areIsomorphic(graph1: AdjacencyMatrix<T>, graph2: AdjacencyMatrix<R>) {
        if (graph1 === graph2 ||
            graph1.storage === graph2.storage ||
            graph1.storage.isEmpty() && graph2.storage.isEmpty()) result = true
        if (graph1.storage.size != graph2.storage.size ||
            graph1.storage.values.any { row -> row.size != graph1.storage.size } ||
            graph2.storage.values.any { row -> row.size != graph2.storage.size }) result = false
        var count = 0
        val permutation = incidenceDoubleArray2.map { count++ }.toIntArray()
        recursive(incidenceDoubleArray2, permutation)
    }

    fun recursive(incidenceDoubleArray: Array<IntArray>, permutation: IntArray) {
        if (result) return
        var complete = true
        for (i in 0..incidenceDoubleArray1.size) {
            for (j in 0..incidenceDoubleArray.size) {
                complete = incidenceDoubleArray1[i][j] == incidenceDoubleArray[i][j]
            }
        }
        if (complete) {
            result = true
            return
        }

    }



    fun switchColumns(matrix: Array<Array<Int>>, column1: Int, column2: Int): Array<Array<Int>> {
        for (i in 0..matrix.size) {
            val temp = matrix[column1][i]
            matrix[column1][i] = matrix[column2][i]
            matrix[column2][i] = temp
        }
        return matrix
    }

    fun switchRows(matrix: Array<Array<Int>>, row1: Int, row2: Int): Array<Array<Int>> {
        for (i in 0..matrix.size) {
            val temp = matrix[i][row1]
            matrix[row1][i] = matrix[row2][i]
            matrix[row2][i] = temp
        }
        return matrix
    }

    fun <R> convertToIncidenceDoubleArray(matrix: AdjacencyMatrix<R>): Array<IntArray> {
        val matrixSize = matrix.storage.size
        val doubleArray = Array<IntArray>(matrixSize, { IntArray(matrixSize, { 0 }) })
        var i = 0
        for (row in matrix.storage.values) {
            var j = 0
            for (value in row.values) {
                if (value != null) doubleArray[i][j] = 1
                j++
            }
            i++
        }
        return doubleArray
    }

    /**
     * Randomly maps matrix's elements to the current elements.
     */
    fun mapMatrixKeys(matrix1: AdjacencyMatrix<T>, matrix2: AdjacencyMatrix<R>): Map<T, R> {
        var count = 0
        val numberedMap1 = matrix2.storage.entries.associateBy( { count++ }, { it.key })
        count = 0
        val numberedMap2 = matrix1.storage.entries.associateBy( { count++ }, { it.key })
        return numberedMap1.entries.associateBy({map -> numberedMap2[map.key]!!}, {map -> map.value})
    }
}