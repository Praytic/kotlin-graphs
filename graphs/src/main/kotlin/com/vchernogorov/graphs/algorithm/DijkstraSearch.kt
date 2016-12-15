package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DijkstraSearch<T>(graph: Graph<T>, val start: Vertex<T>,
                                 var onFindShortestPathForVertex: (Vertex<T>, Edge<T>) -> Unit = { vertex, edge -> })
    : GraphAlgorithm<T, Unit>(graph) {

    val INF = Int.MAX_VALUE / 2
    //массив для хранения информации о пройденных и не пройденных вершинах
    val used = graph.vertices.associateTo(mutableMapOf()) { it to false };
    //массив для хранения расстояния от стартовой вершины
    val dist = graph.vertices.associateTo(mutableMapOf()) { it to INF };

    override var result = Unit

    override fun run() {
        val recursiveDijkstra = fun (previousVertex: Vertex<T>) {
            //кратчайшее расстояние до стартовой вершины равно 0
            dist[previousVertex] = 0;
            for (iter in 0 .. n - 1) {
                var currentVertex: Vertex<T>? = null;
                var currentDestination = INF;
                //выбираем вершину, кратчайшее расстояние до которой еще не найдено
                for (undoneVertex in graph.vertices
                        .filter { vertex -> used[vertex] != true }
                        .filter { vertex -> currentDestination >= dist[vertex]!! }) {
                    currentVertex = undoneVertex;
                    currentDestination = dist[undoneVertex]!!;
                }
                //рассматриваем все дуги, исходящие из найденной вершины
                if (currentVertex != null) {
                    var selectedEdge: Edge<T>? = null
                    for (edge in graph.getOutgoingEdges(currentVertex)) {
                        val u = edge.to;
                        val weightU = edge.cost;
                        //релаксация вершины
                        if (dist[currentVertex]!! + weightU.toInt() < dist[u]!!) {
                            dist[u] = dist[currentVertex]!! + weightU.toInt();
                            selectedEdge = edge
                        }
                    }
                    //помечаем вершину v просмотренной, до нее найдено кратчайшее расстояние
                    used[currentVertex] = true;
                    if (selectedEdge != null) {
                        onFindShortestPathForVertex.invoke(currentVertex, selectedEdge)
                    }
                }
            }
        }
        recursiveDijkstra.invoke(start)
    }
}