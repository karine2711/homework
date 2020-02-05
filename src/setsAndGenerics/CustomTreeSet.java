package setsAndGenerics;



import java.util.*;

public class CustomTreeSet<Type extends Comparable<Type>> implements Iterable<Type> {
    private Node root = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void printAll(){
        System.out.println("--------------Print sorted set-----------------");
        Iterator iterator=this.iterator();
        for (Type element:this) {
            System.out.println(element);
        }
        System.out.println("-------------------------------------------------");
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
        Node node = findNode(object);
        Node parent = node.parent;
        Node left = node.left;
        Node right = node.right;
        if (parent != null) {
            parent.right = left;
        }
        Node leftsrightLeaf = findRightLeaf(left);
        if (leftsrightLeaf != null) {
            leftsrightLeaf.right = right;
        } else if (parent != null) {
            parent.right = right;
        } else {
            root = right;
        }
        size--;
        return true;
    }

    public boolean contains(Type object) {
        return findNode(object) == null ? false : true;
    }

    private void findPlace(Type object, Node node) {
        if (object.compareTo(node.current) < 0) {
            if (node.left == null) {
                node.left = new Node(object, null, null, node);
            } else {
                findPlace(object, node.left);
            }
        } else if (object.compareTo(node.current) >= 0) {
            if (node.right == null) {
                node.right = new Node(object, null, null, node);
            } else {
                findPlace(object, node.right);
            }
        }
    }

    private Node findRightLeaf(Node startNode) {
        if (startNode == null) {
            return null;
        }
        Node position = startNode;
        while (position.right != null) {
            position = position.right;
        }
        return position;
    }

    private Node findLeftLeaf(Node startNode) {
        if (startNode == null) {
            return null;
        }
        Node position = startNode;
        while (position.left != null) {
            position = position.left;
        }
        return position;
    }

    private Node findNode(Type object) {
        Node node = root;
        while (node != null) {
            if (node.current.equals(object)) {
                return node;
            } else if (object.compareTo(node.current) < 0) {
                node = node.left;
            } else if (object.compareTo(node.current) >= 0) {
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public Iterator<Type> iterator() {
        return new CustomTreeSetIterator();
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

    private class CustomTreeSetIterator implements Iterator<Type> {
        Stack<Node> nodeStack = new Stack<>();
        LinkedList<Type> elementList = new LinkedList<>();

        @Override
        public boolean hasNext() {
            return !elementList.isEmpty();
        }

        @Override
        public Type next() {
            if (hasNext()) {
                return elementList.removeFirst();
            } else {
                return null;
            }
        }

        public CustomTreeSetIterator() {
            collectElements(root);
        }

        public void collectElements(Node current) {
            Node node = current;
            nodeStack.push(node);
            while (node.left != null) {
                node = node.left;
                nodeStack.push(node);
            }
            while (!nodeStack.empty()){
                Node nodei=nodeStack.pop();
                elementList.add(nodei.current);
                if (nodei.right != null) {
                    collectElements(nodei.right);
                }
            }
        }
    }
}
