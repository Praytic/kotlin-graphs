package com.vchernogorov.graphs.model

import javax.naming.OperationNotSupportedException

open class Tree<T>(vertices: MutableSet<Vertex<T>>, edges: MutableSet<Edge<T>>) : Graph<T>(vertices, edges) {

    override fun addComponent(graph: Graph<T>) {
        throw OperationNotSupportedException()
    }
}