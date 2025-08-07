package cs1501.p1;

/**
 * Binary Search Tree Node class for CS1501 Project 1. This subclass of BinaryNode enforces that the
 * element type must be a self-comparable type. K is the generic key type. By filling the second
 * generic type of BinaryNode, this subclass ensures that objects of type BinarySearchNode have
 * children of their same type (not the general BinaryNode). Thus, nodes can be assumed to be
 * populated with keys of a self-comparable type.
 *
 * @author Dr. Farnan
 * @author Dr. Garrison
 */
public class BinarySearchNode<K extends Comparable<? super K>>
extends BinaryNode<K, BinarySearchNode<K>> {

    /**
     * Constructor that accepts the key to be held by the new node
     */
    public BinarySearchNode(K key) {
        // Just call the superclass constructor
        super(key);
    }

}

