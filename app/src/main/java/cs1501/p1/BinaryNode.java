package cs1501.p1;

/**
 * Binary Tree Node class for CS1501 Project 1. Note that K is the (generic) key type, and N is the
 * (generic) node type. BinaryNode has child references of type BinaryNode; subclasses should fill N
 * with their own type to enforce that (for instance) every BinarySearchNode has child references of
 * type BinarySearchNode, not the regular BinaryNode.
 * @author Dr. Farnan
 * @author Dr. Garrison
 */
public class BinaryNode<K, N extends BinaryNode<K, ?>> {

    /**
     * Reference to the key held by this node
     */
    protected K key;

    /**
     * Left child reference
     */
    protected N left;

    /**
     * Right child reference
     */
    protected N right;

    /**
     * Constructor that accepts the key to be held by the new node
     */
    public BinaryNode(K k) {
        key = k;
    }

    /**
     * Determines this node's key
     *
     * @return Reference to this node's key
     */
    public K getKey() {
        return key;
    }

    /**
     * Determines this node's left child
     *
     * @return Reference to this node's left child
     */
    public N getLeft() {
        return left;
    }

    /**
     * Determines this node's right child
     *
     * @return Reference to this node's right child
     */
    public N getRight() {
        return right;
    }

    /**
     * Modifies this node's left child
     *
     * @param l BinaryNode to set as the left child
     */
    public void setLeft(N l) {
        left = l;
    }

    /**
     * Modifies this node's right child
     *
     * @param r BinaryNode to set as the right child
     */
    public void setRight(N r) {
        right = r;
    }

}

