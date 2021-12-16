package com.company;
public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new LabBinarySearchTree<T>(kopyala(getRoot()));
    }

    public BTNode<T> kopyala(BTNode<T> node){
        if (node==null)
            return null;
        BTNode<T> newnode=new BTNode<>(node.value,null,null);
        newnode.left=kopyala(node.left);
        newnode.right=kopyala(node.right);
        return newnode;
    }

    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> node = find(getRoot(),value);
        if (node==null|| node.right==null)
            return null;
        node=node.right;
        while(node.left!=null)
            node=node.left;
        return node;
    }
    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> node = find(getRoot(),value);
        if (node==null || node.right==null)
            return null;
        node=node.left;
        while(node.right!=null)
            node=node.right;
        return node;
    }
    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> current = getRoot();
        return find2(current,node);
    }
    public BTNode<T> find2(BTNode<T>current,BTNode<T> node){
        if(current==null)
            return current;
        if(current.value.compareTo(node.value)<0){
            if (node==current.right || node==current.left)
                return current;

            return find2(current.right,node);
        }
        else if (current.value.compareTo(node.value)>0){
            if (node==current.left || node==current.right)
                return current;

            return find2(current.left,node);
        }
        return null;
    }

}
