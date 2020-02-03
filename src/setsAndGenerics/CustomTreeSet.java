package setsAndGenerics;

import java.util.Iterator;

public class CustomTreeSet<Type extends Comparable<Type>> implements Iterable<Type> {
    Node root = null;

    public boolean add(Type object) {
        if(this.contains(object)){
            return false;
        }
        if (root == null) {
            root = new Node(object, null, null, null);
        } else {
            findPlace(object, root);
        }
        return true;
    }

    public boolean contains(Type object){
        for (Type object1:this) {
            if(object.equals(object1)){
                return true;
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

    private Node traverseLeft() {
        if(root==null){
            return null;
        }
        Node position = root;
        while (position.left != null) {
            position = position.left;
        }
        return position;
    }

    @Override
    public Iterator<Type> iterator() {
        Node LeftEndLeaf = traverseLeft();
        return new CustomTreeSetIterator(LeftEndLeaf);
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


    private class CustomTreeSetIterator implements Iterator {
        Node position;
        boolean rightReturned = false;

        public CustomTreeSetIterator(Node leftEndLeaf) {
            position = new Node(null, null, null, leftEndLeaf);
        }

        @Override
        public boolean hasNext() {
            if (position.right != null || position.parent != null) {
                return true;
            }
            return false;

        }

        @Override
        public Type next() {
            if (this.hasNext()) {
                if (position.right != null && !rightReturned) {
                    rightReturned = true;
                    return position.right.current;
                } else {
                    position = position.parent;
                    rightReturned = false;
                    return position.current;
                }
            }
            return null;
        }
    }

}
