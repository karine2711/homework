package setsAndGenerics;

public class CustomTreeSet<Type extends Comparable<Type>> {
 Node root=null;
    private class Node{
        Node parent;
        Node left;
        Node right;
       Type current;

        public Node(Type t, Node left, Node right,Node parent ) {
            this.left = left;
            this.right = right;
            this.current = t;
            this.parent=parent;
        }
    }

    public void add(Type object){
        if(root==null){
            root=new Node(object,null,null,null);
        }else {findPlace(object,root);}
    }

    private void findPlace(Type object,Node node){
        if(object.compareTo(node.current)<0){
            if(node.left==null){
               node.left=new Node(object,null,null,node);
            }else {
                 findPlace(object,node.left);
            }
        }else if (object.compareTo(node.current)>0){
            if(node.right==null){
                node.right=new Node(object,null,null,node);
            }else {
                 findPlace(object,node.right);
            }
        }
    }

//    public boolean contains(Type object){
//
//    }
}
