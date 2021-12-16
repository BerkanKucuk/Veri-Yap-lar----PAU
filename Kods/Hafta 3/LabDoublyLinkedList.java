public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
     public void insertAt(int index, T value) {
     Node<T> current= getHead();
        
        if(index==0)
        addFirst(value);
        
        else if (index==size())
        addLast(value);
        
        else{
            int i =0;
            while(i<index-1 && current!=null){
                i++;
                current=current.next;
            }
            Node<T> yeni=new Node(value,current.next,current);
            current.next.previous= yeni;
            current.next=yeni;
            setSize(size()+1);
}
     }
    /**
     * Verilen konumdaki elemanı siler
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
        Node<T> current = getHead();
        Node<T> current2= getHead();
        if (index == 0)
            removeFirst();
        else if (index == size() || index > size())
            removeLast();
        else {
            int i = 0;
            while (i < index-1 && current != null) {
                i++;
                current = current.next;
            }
            current2=current.next;
            current.next=current.next.next;
            setSize(size()-1);
    }
        return current2.value;
}
}

        
  

