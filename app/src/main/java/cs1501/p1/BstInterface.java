package cs1501.p1;

/**
 * Binary Search Tree specification interface for CS1501 Project 1. Note that K is the generic key
 * type.
 * @author Dr. Farnan
 * @author Dr. Garrison
 */
public interface BstInterface<K extends Comparable<? super K>> {

    /**
     * Adds a new key to this BST in its correct location and returns true. If a null key is
     * provided, put throws {@code NullPointerException} and makes no changes. If the provided key
     * already exists in this BST, then put makes no changes and returns false.
     *
     * @param key Generic type key to be added to this BST
     * @throws NullPointerException if {@code key} is {@code null}.
     * @return true if the key was added, false if it was a duplicate
     */
    public boolean put(K key) throws NullPointerException;

    /**
     * Check if this BST contains a key.
     *
     * @param key Generic type key to look for in this BST
     * @return true if key is in this BST, false otherwise
     */
    public boolean contains(K key);

    /**
     * Remove a key from this BST, if key is present in this BST. If this key is not present in this
     * BST, {@code delete} throws {@code MissingKeyException} and makes no changes.
     *
     * @param key Generic type key to (attempt to) remove from this BST
     * @throws MissingKeyException if the key is not found in this BST
     */
    public void delete(K key) throws MissingKeyException;

    /**
     * Determines the height of this BST. Height is defined as the number of nodes along the longest
     * path from the root to a leaf.
     *
     * <p>
     * A single node tree has a height of 1, and an empty tree has a height of 0.
     *
     * @return the height of this BST
     */
    public int height();

    /**
     * Determines if this BST is height-balanced.
     *
     * <p>
     * A height balanced binary tree is one where the left and right subtrees of all nodes differ in
     * height by no more than 1.
     *
     * @return true if this BST is height-balanced, false if it is not
     */
    public boolean isBalanced();

    /**
     * Produce a '-' separated String of all keys in ascending order
     *
     * <p>
     * Performs an in-order traversal of this tree and produce a String containing the keys in
     * ascending order, separated by plain hyphens (not n-dash, m-dash, etc.). Keys are converted to
     * strings using {@code toString()}.
     *
     * @return String containing the keys in ascending order, separated by '-'
     */
    public String inOrderTraversal();

    /**
     * Produces a String representation of this BST
     *
     * <p>
     * Performs a pre-order traversal of this BST in order to produce a String representation of
     * this BST. The representation should be a semicolon-separated list where each entry represents
     * a single node (or null placeholder). Each entry should take the form: *type*[*key*]. This
     * method uses 4 node types:
     *     `R`: The root of this tree
     *     `I`: An interior node of this tree (e.g., not the root, not a leaf)
     *     `L`: A leaf of this tree
     *     `X`: A placeholder for a null reference (which always has a key of {@code "NULL"})
     * For each node, this method lists its left child first, then its right child. It does not list
     * children of leaves. The `X` type is used only for nodes that have exactly one valid child.
     *
     * @return String containing all nodes in this BST in pre-order, formatted as described above,
     * separated by ';'
     */
    public String serialize();

    /**
     * Produce a deep copy of this BST that is reversed (i.e., left children hold keys greater than
     * the current key, right children hold keys less than the current key). Note that this method
     * produces an invalid BST, on which calling {@code put}, {@code contains}, etc. will not work
     * as expected!
     *
     * @return Deep copy of the BST, reversed
     */
    public BstInterface<K> reverse();

}

