package setsAndGenerics;

import java.util.*;

/**
 * Custom implementation of a sorted set.
 * Contains methods
 * {@link #add(Comparable) add()},
 * {@link #remove(Comparable) remove()},
 * {@link #getSize() getSize()},
 * {@link #contains(Comparable) contains()},
 * {@link #printAll() printAll()},   and
 * {@link #iterator() public methods},
 * <p>
 * It's a generic class that stores objects in a Red and Black tree data structure.
 * It doesn't allow duplicates or nulls.
 * When iterated through, the objects returned are sorted in acsending order.
 *
 * @author Karine Gevorgyan
 */
public class CustomTreeSet<Type extends Comparable<Type>> implements Iterable<Type> {
    private Node root = null;  //Represent the root of the tree
    private int size = 0; //The total number of elements present in the set

    /**
     * The getSize() method return the size of the CustomSet
     *
     * @return size Represents the number of objects contained in the set
     */
    public int getSize() {
        return size;
    }

    /**
     * Iterates through the set and prints all elements in the console.
     */
    public void printAll() {
        System.out.println("--------------Print sorted set-----------------");
        Iterator iterator = this.iterator();
        for (Type element : this) {
            System.out.println(element);
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     * Adds new objects to the CustomTreeSet
     *
     * @param object The object to be added to the list. Object must implement Comparable
     * @return t A boolean specifier, which is false if something went wrote and the object was not added
     */
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

    /**
     * Removed the specified object from the CustomTreeSet
     *
     * @param object The object to be removed
     * @return Is false, if the object is not present in the set and 'true' otherwise
     */
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

    /**
     * @param object the object to be searched for
     * @return true if the specified object is present in the set, false otherwise
     */
    public boolean contains(Type object) {
        return findNode(object) == null ? false : true;
    }

    /**
     * The findPlace() function takes the node and compares to the object.
     * If the object is bigger  than the 'current' of the node, it checks if the right node is null.
     * If the right node IS null, the object is added as the new right node of the node in parameters,
     * however if it is already filled, this right node is passed to this same function and
     * the steps are repeated.
     * If the object is smaller than the 'current' of the node, it check the left node for being null
     * and does the same things as in th 'isBiggerThanCurrent' case
     *
     * @param object the object to be added to the tree
     * @param node   the node, that has .current equal to object specified
     */
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

    /**
     * Starting a specified point, always goes right,while traversing the tree,
     * until it finds the rightmost node and returns it
     *
     * @param startNode the traversal to right starts from this node
     * @return the rightmost node for the given startNode
     */
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

    /**
     * Starting a specified point, always goes left,while traversing the tree,until it finds
     * the leftmost node and returns it
     *
     * @param startNode the traversal to left starts from this node
     * @return the leftmost node for the given startNode
     */
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

    /**
     * Given an object, find the node in the CustomTreeSet tree, that contains it.
     *
     * @param object the object to be searched for
     * @return the node, that has .current equal to object specified,
     * if there is no such node, returns null
     */
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

    //Returns an iterator for the CustomTreeSet class
    @Override
    public Iterator<Type> iterator() {
        return new CustomTreeSetIterator();
    }

    /**
     * Represents a single unit in a tree and this unit knows its parent, current object and
     * left and right children
     */
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

    /**
     * Is responsible for providing an iterator object to the iterator() method of this class.
     * Uses a Stack and a LinkedList to make iteration available.
     */
    private class CustomTreeSetIterator implements Iterator<Type> {
        //dynamically collects elements in branches and distributes them to the elementList if necessary
        Stack<Node> nodeStack = new Stack<>();
        //contains all elements present in the tree, sorted in ascending order
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

        /**
         * Evertytime a CstomTreeSetIterator is instantiated, all elements of the tree are
         * moved to the elementList by the call of collectElements
         */
        public CustomTreeSetIterator() {
            collectElements(root);
        }

        /**
         * A resursive function, which reseives a node and then begining from that node
         * always goes to the left until reaching the leaf. It, than, pops the elements of the stack
         * one by one, and adds them to the elementList, also, if the element's right child is not null
         * the function is called again, receiving the right child as a Node parameter.
         * This process continues until the 'current' node of the function has neither a parent nor a
         * right child, which means it's the right leaf of the tree
         *
         * @param current all elements to the left from this 'current' node are passed to the stack
         */
        public void collectElements(Node current) {
            Node node = current;
            nodeStack.push(node);
            while (node.left != null) {
                node = node.left;
                nodeStack.push(node);
            }
            while (!nodeStack.empty()) {
                Node nodei = nodeStack.pop();
                elementList.add(nodei.current);
                if (nodei.right != null) {
                    collectElements(nodei.right);
                }
            }
        }
    }
}
