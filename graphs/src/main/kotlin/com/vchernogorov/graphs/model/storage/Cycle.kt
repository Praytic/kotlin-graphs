package com.vchernogorov.graphs.model.storage

import com.vchernogorov.graphs.model.Edge

class Cycle<T>(storage: MutableSet<Edge<T>>) : Path<T>(storage)