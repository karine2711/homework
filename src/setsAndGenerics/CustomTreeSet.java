package setsAndGenerics;

import javax.swing.plaf.TabbedPaneUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomTreeSet<Type extends Comparable<Type>>{
    private Node root = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean add(Type object) {
        if (root == null) {
            root = new Node(object, null, null, null);
        } else if (this.contains(object)) {
            return false;
        } else {
            findPlace(object, root);
        }
        size++;
        return true;
    }

    public boolean remove(Type object) {
        if (!this.contains(object)) {
            return false;
        }
       Node node= findNode(object);
       Node parent=node.parent;
       Node left=node.left;
       Node right=node.right;
       if(parent!=null){
           parent.right=left;
       }
       Node leftsrightLeaf=traverseRight(left);
       if(leftsrightLeaf!=null){
       leftsrightLeaf.right=right;
       }else if(parent!=null){
           parent.right=right;
       } else {
           root=right;
       }
       size--;
        return true;
    }

    public boolean contains(Type object) {
        return  findNode(object)==null?false:true;
    }

    private void findPlace(Type object, Node node) {
        if (object.compareTo(node.current) < 0) {
            if (node.left == null) {
                node.left = new Node(object, null, null, node);
            } else {
                findPlace(object, node.left);
            }
        } else if (object.compareTo(node.current) > 0) {
            if (node.right == null) {
                node.right = new Node(object, null, null, node);
            } else {
                findPlace(object, node.right);
            }
        }
    }

    private Node traverseRight(Node startNode) {
        if (startNode == null) {
            return null;
        }
        Node position=startNode;
        while (position.right!= null) {
            position = position.right;
        }
        return position;
    }

    private Node findNode(Type object) {
        Node node =root;
        while(node!=null ){
            if(node.current.equals(object)){
                return  node;
            } else if(object.compareTo(node.current)<0){
                node=node.left;
            }else if(object.compareTo(node.current)>0){
                node=node.right;
            }
        }
        return null;
    }

    private class Node {
        Node parent;
        Node left;
        Node right;
        Type current;

        public Node(Type t, Node left, Node right, Node parent) {
            this.left = left;
            this.right = right;
            this.current = t;
            this.parent = parent;
        }
    }

}
