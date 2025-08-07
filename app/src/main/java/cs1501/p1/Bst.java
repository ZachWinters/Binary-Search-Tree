package cs1501.p1;


/**
 * Initial class for Bst. K is the generic key type.
 */
public class Bst<K extends Comparable<? super K>> implements BstInterface<K> {

    private BinarySearchNode<K> root;
    private boolean dup= true;

    public boolean put(K key) throws NullPointerException {
        if(key == null) throw new NullPointerException("Key is null");
        root = put(root, key);
        return dup;
    }
    private BinarySearchNode<K> put(BinarySearchNode<K> r, K key){
        if(r == null) return new BinarySearchNode<>(key);

        int cmp = key.compareTo(r.getKey());
        if      (cmp < 0) r.setLeft(put(r.getLeft(),key));
        else if (cmp > 0) r.setRight(put(r.getRight(),key));
        else dup = false;
        return r;
    }  
    private int i;
    private void check(){
        System.out.println(i++);
    }
    public boolean contains(K key) {
        return contains(root, key);
        
    }
    private boolean contains(BinarySearchNode<K> x, K key){
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return false; 

        if(key.equals(x.key)) return true;
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) return contains(x.getLeft(), key);
        else if (cmp > 0) return contains(x.getRight(),key);
        else return false; // The first check for x should never allow this to run
    }
    

    public void delete(K key){
        if(key == null) System.out.println("Null");
        root = delete(root, key);
        
    }
    
    private BinarySearchNode<K> delete(BinarySearchNode<K> r, K key){
        if (r == null) return null;
        int cmp = key.compareTo(r.getKey());
        if(cmp < 0)         r.setLeft(delete(r.getLeft(),key));
        else if(cmp > 0)    r.setRight(delete(r.getRight(),key));
        else{
            if(r.getRight() == null) return r.getLeft();
            if(r.getLeft() == null) return r.getRight();
            BinarySearchNode<K> minNode = r;
            r = findMin(r.getRight());
            r.setRight(delete(minNode.getRight(), minNode.getKey()));
        }        
        return r;
    }

    private BinarySearchNode<K> findMin(BinarySearchNode<K> r) {
        while (r.getLeft() != null) {
            r = r.getLeft();
        }
        return r;
    }
   

    public int height() {
        return height(root);
    }

    private int height(BinarySearchNode<K> r){
        if(r == null) return 0;
        else{
            int L = height(r.getLeft());
            int R = height(r.getRight());

            if(L>R) return L+1;
            else return R+1;
        }
        
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(BinarySearchNode<K> r){
        if(r == null) return true;
        int L = height(r.getLeft());
        int R = height(r.getRight());
        
        if(Math.abs(L-R) <= 1) return true;
        return false;
    }


    public String inOrderTraversal() {
        StringBuilder result = new StringBuilder();
        inOrderTraversal(root, result);
        return result.toString();
    }
    private void inOrderTraversal(BinarySearchNode<K> r, StringBuilder result){
        if(r != null){ 
            inOrderTraversal(r.getLeft(), result);
            if(result.length()>0) result.append("-");
        
        result.append(r.getKey().toString());
        inOrderTraversal(r.getRight(), result);
        }

    }


    public String serialize() {
        StringBuilder result = new StringBuilder();
        preOrder(root, result);
        return result.toString();
    }
    private void preOrder(BinarySearchNode<K> r, StringBuilder result){
        if(r!=null){ 
            preOrder(r.getLeft(), result);
            if(result.length()>0) result.append(";");
        }
        result.append(r.getKey().toString());
        preOrder(r.getRight(), result);
    }

    @Override
    public BstInterface<K> reverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reverse'");
    }
    

}

