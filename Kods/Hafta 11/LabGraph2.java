package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LabGraph2<T> donecek = new LabGraph2<>();
        for (Vertex<T> v : vertices)
            donecek.addVertex(v.value);
        for (Vertex<T> v : vertices)
            for (Edge<T> e : v.edges)
                donecek.addEdge(e.from.value, e.to.value);
        return donecek;
    }

    @Override
    public void removeVertex(T deger) {
        Vertex<T> silinecek = verticesMap.get(deger);
        if (silinecek == null)
            return;
        vertices.remove(silinecek);
        for (Vertex<T> v : vertices) {
            Edge<T> silinecekKenar = null;
            for (Edge<T> e : v.edges) {
                if (e.to.value.equals(deger)) {
                    silinecekKenar = e;
                    break;
                }
            }
            if (silinecekKenar != null)
                v.edges.remove(silinecekKenar);
        }
    }
       /* Vertex<T> silinecek = verticesMap.get(deger);
         if(silinecek==null)
            return;
        vertices.remove(silinecek);
        for(Vertex<T> v:vertices){
            for(Edge<T> e:v.edges){
                if(e.to.value.equals(deger)){
                    v.edges.remove(e);
                    break;
                }
    }
} 
}
*/

    @Override
    public List<T> topologicalSort() {
        LabGraph2<T> donecek = new LabGraph2<>();
        for (Vertex<T> v : vertices)
            donecek.addVertex(v.value);
        for (Vertex<T> v : vertices)
            for (Edge<T> e : v.edges)
                donecek.addEdge(e.from.value, e.to.value);


          List<T> list = new LinkedList<>();
         for (Vertex<T> vertex : donecek.vertices){
            if (inDegree(vertex.value)==0){
                list.add(vertex.value);
                donecek.vertices.remove(vertex);
            }
        }
        return list;
    }
}
