package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal abstract class GraphAlgorithm<T, R>(var graph: Graph<T>) : Algorithm<R>()