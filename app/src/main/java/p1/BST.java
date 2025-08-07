package cs1501.p1;

public class BST<T extends Comparable<T>> implements BST_Inter<T>{

    private BTNode<T> root;

    public BST(){
        root = null;
    }



    public void put(T key) {
        root = putRec(root,key);
    }
    private BTNode<T> putRec(BTNode<T> curr, T key){
        if(curr == null){
            return new BTNode<T>(key);
        }
        if(key.compareTo(curr.getKey()) < 0){
            curr.setLeft(putRec(curr.getLeft(), key));
        }else if(key.compareTo(curr.getKey()) > 0){
            curr.setRight(putRec(curr.getRight(), key));
        }
        return curr;
    }

/* */

    public boolean contains(T key) {
        return containsRec(root, key);
    }
    private boolean containsRec(BTNode<T> curr, T key) {
        if (curr == null) {
            return false;
        }
        int cmp = key.compareTo(curr.getKey());
        if (cmp < 0) return containsRec(curr.getLeft(), key);
        if (cmp > 0) return containsRec(curr.getRight(), key);
        return true; 
    }

/* */

    public void delete(T key) {
        root = deleteRec(root, key);
    }
    private BTNode<T> deleteRec(BTNode<T> curr, T key) {
        if (curr == null) {
            return null;
        }
        int cmp = key.compareTo(curr.getKey());
        if (cmp < 0) {
            curr.setLeft(deleteRec(curr.getLeft(), key));
        } else if (cmp > 0) {
            curr.setRight(deleteRec(curr.getRight(), key));
        } else {
            if (curr.getLeft() == null) return curr.getRight();
            if (curr.getRight() == null) return curr.getLeft();
            BTNode<T> temp = curr;
            curr = findMin(temp.getRight()); 
            curr.setRight(deleteMin(temp.getRight()));
            curr.setLeft(temp.getLeft());
        }
        return curr;
    }
    private BTNode<T> findMin(BTNode<T> curr) {
        while (curr.getLeft() != null) curr = curr.getLeft();
        return curr;
    }

    private BTNode<T> deleteMin(BTNode<T> curr) {
        if (curr.getLeft() == null) return curr.getRight();
        curr.setLeft(deleteMin(curr.getLeft()));
        return curr;
    }

/* */

public int height() {
    return heightRec(root);
}

private int heightRec(BTNode<T> curr) {
    if (curr == null) return 0;
    return 1 + Math.max(heightRec(curr.getLeft()), heightRec(curr.getRight()));
}

/* */

public boolean isBalanced() {
    return isBalancedRec(root) != -1;
}

private int isBalancedRec(BTNode<T> curr) {
    if (curr == null) return 0;
    int leftHeight = isBalancedRec(curr.getLeft());
    if (leftHeight == -1) return -1;
    int rightHeight = isBalancedRec(curr.getRight());
    if (rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return 1 + Math.max(leftHeight, rightHeight);
}

/* */

public String inOrderTraversal() {
    StringBuilder sb = new StringBuilder();
    inOrderTraversalRec(root, sb);
    if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
}

private void inOrderTraversalRec(BTNode<T> curr, StringBuilder sb) {
    if (curr != null) {
        inOrderTraversalRec(curr.getLeft(), sb);
        sb.append(curr.getKey()).append(":");
        inOrderTraversalRec(curr.getRight(), sb);
    }
}

/* */

public String serialize() {
    StringBuilder sb = new StringBuilder();
    serializeRec(root, sb, "R");
    if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1); 
    }
    return sb.toString();
}

private void serializeRec(BTNode<T> curr, StringBuilder sb, String type) {
    if (curr == null) {
        sb.append("X(NULL),");
        return;
    }
    if (curr != root && curr.getLeft() == null && curr.getRight() == null) {
        sb.append("L(").append(curr.getKey()).append("),");
    } else {
        sb.append(type).append("(").append(curr.getKey()).append("),");
    }

    if (curr.getLeft() != null || curr.getRight() != null) {
        serializeRec(curr.getLeft(), sb, "I");
        serializeRec(curr.getRight(), sb, "I");
    }
}




/* */

public BST_Inter<T> reverse() {
    BST<T> reversedTree = new BST<>();
    reversedTree.root = reverseRec(this.root);
    return reversedTree;
}

private BTNode<T> reverseRec(BTNode<T> node) {
    if (node == null) return null;

    BTNode<T> left = reverseRec(node.getRight());
    BTNode<T> right = reverseRec(node.getLeft());

    BTNode<T> newNode = new BTNode<>(node.getKey());
    newNode.setLeft(left);
    newNode.setRight(right);

    return newNode;
}



    
}
