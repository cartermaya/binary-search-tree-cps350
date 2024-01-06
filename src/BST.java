// BST class
// Maya Carter, 11/10/2023

public class BST {

    private TreeNode root;   // reference to the tree root

    // constructor
    public BST() {
        root = null;
    }

    public static class TreeNode {

        private County county_info;    // the reference to the information of the county
        private TreeNode left;         // reference to the left child
        private TreeNode right;        // reference to the right child

        // TreeNode constructor
        public TreeNode(County county_info) {
            this.county_info = county_info;
            left = null;
            right = null;
        }

    } // end TreeNode


    // getter for root
    public TreeNode getRoot() {
        return root;
    }

    // preOrder traversal through BST (NLR)
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.county_info);
            preOrder(root.left);
            preOrder(root.right);
        }
    } // end preOrder


    // inOrder traversal through BST (LNR)
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.county_info);
            inOrder(root.right);
        }
    } // end inOrder


    // calls recursive insert method with root and given key
    public void insert(County county) {
        root = insert(this.root, county);
    } // end insert

    // inserts given key
    private TreeNode insert(TreeNode root, County county) {
        // if bst is empty, set root as new TreeNode with given value and return root
        if (root == null) {
            root = new TreeNode(county);
            return root;
        }
        // else if key's FIPS is less than root's FIPS, set root's left child to result of recursive call with left child
        else if (county.getFIPS() < root.county_info.getFIPS()) {
            root.left = insert(root.left, county);
        }
        // else if key's FIPS is greater than root's FIPS, set root's right child to result of recursive call with right child
        else if (county.getFIPS() > root.county_info.getFIPS()) {
            root.right = insert(root.right, county);
        }

        return root;

    } // end insertRecursive


    // calls delete method with root and given fips key
    public void delete(int fips) {
        root = delete(root, fips);
    } // end delete

    // deletes county that matches the given FIPS key code
    private TreeNode delete(TreeNode root, int fips) {
        // value is not in tree
        if (root == null) {
            return root;
        }

        // if given fips key smaller than root's fips value
        if (fips < root.county_info.getFIPS()) {
            root.left = delete(root.left, fips);
            return root;
        }
        // else if given fips key larger than root's fips value
        else if (fips > root.county_info.getFIPS()) {
            root.right = delete(root.right, fips);
            return root;
        }
        // else if given fips key is equal to root's fips value
        else {
            // if no left child
            if (root.left == null) {
                // return right child, which can also be null
                return root.right;
            }
            // else if no right child
            else if (root.right == null) {
                // return left child
                return root.left;
            }
            // else if there are two children
            else {
                // if left child has no right child
                if (root.left.right == null) {
                    root.county_info = root.left.county_info; // replace root's county with left's county
                    root.left = root.left.left; // replace root's left child with left child of root's left child
                }
                // else if left child has right child
                else {
                    root.county_info = findLargestChildAndRemoveIt(root.left);
                }

                return root;
            }
        }
    } // end delete

    // helper method used in delete method, finds root's largest child, removes it, and returns removed value
    private County findLargestChildAndRemoveIt(TreeNode root) {
        // if root has no right child, it is the inorder predecessor
        if (root.right.right == null) {
            County returnValue = root.right.county_info;
            root.right = root.right.left;  // delete root's right child
            return returnValue;
        }
        // else if root has a right child, do a recursive call
        else {
            return findLargestChildAndRemoveIt(root.right);
        }
    } // end findLargestChildAndRemoveIt

} // end BST
