package com.company;

import java.util.List;
import java.util.Map;

public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> vertex = verticesMap.get(deger);
        if (vertex != null)
            return vertex.edges.size();
        return -1;
    }

    @Override
    public int inDegree(T deger) {
        Vertex<T> vertex = verticesMap.get(deger);
        if (vertex != null) {
            int indegree = 0;
            for (Vertex<T> a : vertices) {
                for(Edge<T> b : edges.get(a.value)) {
                    if (b.to.value.equals(deger)){
                        indegree++;
                    }
                }
            }
            return indegree;
        }
        return -1;
    }
}
