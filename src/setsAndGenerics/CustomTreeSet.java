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

//    public boolean remove(Type object) {
//        if (!this.contains(object)) {
//            return false;
//        }
//     Node node=findNode(object,root);
//        if(node){
//            Node parent=node.parent;
//            Node left=node.left;
//            Node right=node.right;
//            if(parent.current.compareTo(node.current)>0){
//                parent.right=node.right;
//            }
//            return true;
//        }else {
//            return false;
//        }
//    }

    public boolean contains(Type object) {
        Node node =root;
      while(node!=null ){
          if(node.current==object){
              return true;
          } else if(object.compareTo(node.current)<0){
              node=node.left;
          }else if(object.compareTo(node.current)>0){
              node=node.right;
          }
      }
        return false;
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

//    private Node traverseLeft() {
//        List<Node> result=new ArrayList<>();
//        if (root == null) {
//            return null;
//        }
//        Node position = root;
//        while (position!= null) {
//            result.add(position);
//            position = position.left;
//        }
//        return result;
//    }

    private Node findNode(Type object, Node position) {
        Node pointer = position;
        if (position == null) {
            return null;
        } else if (position.current == object) {
            return position;
        } else if (object.compareTo(position.current) < 0) {
            return findNode(object, position.left);
        } else if (object.compareTo(position.current) > 0) {
            return findNode(object, position.right);
        }
        return null;
    }

//    @Override
//    public Iterator<Type> iterator() {
//        Node LeftEndLeaf = traverseLeft();
//        return new CustomTreeSetIterator(LeftEndLeaf);
//    }


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


//    private class CustomTreeSetIterator implements Iterator {
//        Node position;
//        boolean rightReturned = false;
//        List <Node> leftSideOfCurrentNode=new ArrayList<>();
//
//
//
//        public CustomTreeSetIterator(List leftSideNotes) {
//            Node node=leftSideNotes.get(--leftSideNotes.size());
//            position = new Node(null, null, null, node);
//            leftSideOfCurrentNode=leftSideNotes;
//        }
//
//        @Override
//        public boolean hasNext() {
//            if (position.right != null || position.parent != null) {
//                return true;
//            }
//            return false;
//
//        }
//
//        @Override
//        public Type next() {
//            Node node=poz
//            if (this.hasNext()) {
//                if (position.right != null && !rightReturned) {
//                    rightReturned = true;
//                    return position.right.current;
//                } else {
//                    position = position.parent;
//                    rightReturned = false;
//                    return position.current;
//                }
//            }
//            return null;
//        }
//
//
//    }

}
