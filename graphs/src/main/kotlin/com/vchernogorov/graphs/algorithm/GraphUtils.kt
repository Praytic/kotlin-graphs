package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.algorithm.traversing.DepthFirstSearch
import com.vchernogorov.graphs.model.*
import com.vchernogorov.graphs.model.storage.AdjacencyMatrix
import com.vchernogorov.graphs.model.storage.Cycle
import com.vchernogorov.graphs.model.storage.Path
import sun.reflect.generics.reflectiveObjects.NotImplementedException

val INF = Int.MAX_VALUE / 2

// II.20. Проверить, является ли граф деревом, или лесом, или не является ни тем ни другим.
fun <T> isForest(graph: Graph<T>): Boolean {
    val graph = ExtendedGraph(graph)
    if (graph.vertices.isEmpty()) return false
    var visitedCount = 0

    for (vertex in graph.vertices) {
        if (!graph.visited[vertex]!!) {
            graph.startVertex = vertex
            var hasCycle = false
            val dfs = DepthFirstSearch<T>()
            dfs.onEnterUnvisitedVertex = { v, e -> visitedCount++; graph.visited[vertex] = true }
            dfs.onFindVisitedVertex = { v, e -> hasCycle = true }
            dfs.start(graph)
            if (hasCycle) return false
        }
    }
    return if (visitedCount === graph.vertices.size) true else false
}

// II.20. Проверить, является ли граф деревом, или лесом, или не является ни тем ни другим.
fun <T> isTree(graph: Graph<T>): Boolean {
    val graph = ExtendedGraph(graph)
    if (graph.vertices.size - 1 !== graph.edges.size) return false
    var visitedCount = 0
    var hasCycle = false
    graph.startVertex = graph.vertices.first()

    val dfs = DepthFirstSearch<T>()
    dfs.onEnterUnvisitedVertex = { vertex, edge -> visitedCount++ }
    dfs.onFindVisitedVertex = { v, e -> hasCycle = true }
    dfs.start(graph)

    return if (hasCycle) false else if (visitedCount === graph.vertices.size) true else false
}

// Ib.13. Выяснить, совпадают ли два заданных графа с точностью до изоморфизма.
fun <T, R> areIsomorphic(graph: Graph<T>, graphToCompare: Graph<R>): Boolean {
    val graph = ExtendedGraph(graph)
    if (graph === graphToCompare) return true
    if (graph.vertices.size == 0 && graphToCompare.vertices.size == 0) return true
    if (graph.vertices.size == graphToCompare.vertices.size &&
        graph.edges.size == 0 && graphToCompare.edges.size == 0) return true
    if (graph.vertices.size != graphToCompare.vertices.size) return false
    if (graph.edges.size != graphToCompare.edges.size) return false

    val size = graph.vertices.size
    val incMatrix1 = AdjacencyMatrix(graph).incidenceMatrix
    val incMatrix2 = AdjacencyMatrix(graphToCompare).incidenceMatrix
    val permutation = Permutation(size)
    val incMatrixTemp = AdjacencyMatrix(graphToCompare).incidenceMatrix

    if (incMatrix1 === incMatrix2) return true
    if (incMatrix1.storage.isEmpty() && incMatrix2.storage.isEmpty()) return true
    if (incMatrix1.storage.size != incMatrix2.storage.size) return false

    while (true) {
        var ready = true
        for (i in 0..size - 1) {
            for (j in 0..size - 1) {
                if (incMatrixTemp[i][j] != incMatrix1[i][j]) {
                    ready = false
                    break
                }
            }
            if (!ready) break
        }
        if (ready) return true
        if (permutation.last == permutation.current) return ready

        val perm = permutation.next()
        for (i in 0..size - 1) {
            for (j in 0..size - 1) {
                incMatrixTemp[i][j] = incMatrix2[i][perm[j]]
                incMatrixTemp[i][j] = incMatrix2[perm[i]][j]
            }
        }
    }
}

// II.13. Вывести все пути из u в v.
fun <T> findAllPaths(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>): Set<Path<T>> {
    val graph = ExtendedGraph(graph)
    if (!hasPath(graph, from, to)) return mutableSetOf()
    graph.startVertex = from

    val result = mutableSetOf<Path<T>>()
    val currentPath = Path<T>()

    val dfs = DepthFirstSearch<T>()
    dfs.onEnterUnvisitedVertex = { vertex, edge -> if (edge != null) currentPath.storage.add(edge) }
    dfs.onExitVisitedVertex = { vertex, edge ->
        if (vertex == to) result.add(Path(currentPath))
        currentPath.storage.remove(edge)
    }
    dfs.start(graph)

    return result
}

fun <T> hasPath(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>) = !from.equals(to) && graph[from].isNotEmpty()

// II.32. Найти все кратчайшие циклы орграфа.
fun <T> findAllCycles(graph: Graph<T>): Set<Cycle<T>> {
    throw NotImplementedException()
}

// III. Поиска минимального остовного дерева во взвешенном неориентированном связном графе.
fun <T> findMinimumSpanningTree(graph: Graph<T>): SpanningTree<T> {
    throw NotImplementedException()
}

fun <T> hasNegativeWeightCycles(graph: Graph<T>): Boolean {
    val graph = ExtendedGraph(graph)
    return graph.edges.any { graph.distance[it.from]!! + it.cost < graph.distance[it.to]!! }
}

// IV.8b. Определить множество вершин орграфа, расстояние от которых до заданной вершины не более N.
fun <T> findAllVerticesByPredicate(graph: Graph<T>, to: Vertex<T>, predicate: () -> Boolean): Set<Vertex<T>> {
    throw NotImplementedException()
}

// IV.14c. Вывести все кратчайшие пути из вершины u.
fun <T> findAllShortestPaths(graph: Graph<T>, from: Vertex<T>): Set<Path<T>> {
    throw NotImplementedException()
}

// IV.21a. Найти длину кратчайшего пути из u в v и вывести все пути такой длины.
fun <T> findAllShortestPaths(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>): Set<Path<T>> {
    throw NotImplementedException()
}