
import java.util.*;
public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {

    class EdgeComparator<T extends Comparable<T>> implements Comparator<Edge<T>>{

        @Override
        public int compare(Edge<T> e1, Edge<T> e2) {
            return e1.to.value.compareTo(e2.to.value)*-1;
        }
    }


    @Override
    public List<T> dfs(T baslangic) {
        Stack<Vertex<T>> stack = new Stack<>();
        List<T> visited=new ArrayList<>();
        stack.push(verticesMap.get(baslangic));
        while(!stack.isEmpty()){
            Vertex<T> mevcut = stack.pop();
            if (visited.contains(mevcut.value))
                continue;
            visited.add(mevcut.value);
            List<Edge<T>> kenarlar = new ArrayList<>(mevcut.edges);
            Collections.sort(kenarlar,new EdgeComparator());
            for (Edge<T> kenar:kenarlar)
                stack.push(kenar.to);
        }
        return visited ;
    }

    class EdgeC2<T extends Comparable<T>> implements Comparator<Edge<T>> {

        @Override
        public int compare(Edge<T> o1, Edge<T> o2) {
            return o1.to.value.compareTo(o2.to.value);
        }
    }

    @Override
    public List<T> bfs(T baslangic) {
        Queue<Vertex<T>> a = new ArrayDeque<>();
        List<T> visited = new ArrayList<>();
        a.offer(verticesMap.get(baslangic));
        while (!a.isEmpty()) {
            Vertex<T> mevcut = a.remove();
            if (visited.contains(mevcut.value))
                continue;

            visited.add(mevcut.value);
            List<Edge<T>> kenarlar = new ArrayList<>(mevcut.edges);
            Collections.sort(kenarlar, new EdgeC2());
            for (Edge<T> kenar : kenarlar)
                a.offer(kenar.to);

        }
        return visited;
    }
}