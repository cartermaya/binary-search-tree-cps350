// main for BST class testing
// Maya Carter, 11/10/2023

public class Main {
    public static void main(String[] args) {

        // creating empty binary search tree and adding counties
        BST bst = new BST();
        System.out.println(">> Inserting counties to BST");
        bst.insert(new County("Franklin",49,"Columbus",1264518, 539.87));
        bst.insert(new County("Hamilton",61,"Cincinnati",802374, 407.36));
        bst.insert(new County("Butler",17,"Hamilton",368130, 467.27));
        bst.insert(new County("Montgomery",113,"Dayton",535153, 461.68));
        bst.insert(new County("Clinton",27,"Wilmington",42040, 410.88));

        // displaying pre-order and in-order traversal of bst
        System.out.println("Pre-Order:");
        bst.preOrder(bst.getRoot());
        System.out.println();
        System.out.println("In-Order:");
        bst.inOrder(bst.getRoot());
        System.out.println();

        // inserting new county and displaying tree with pre-order and in-order traversal
        System.out.println(">> Inserting Cuyahoga county to BST");
        bst.insert(new County("Cuyahoga",35,"Cleveland",1249352,458.49));
        System.out.println("Pre-Order:");
        bst.preOrder(bst.getRoot());
        System.out.println();
        System.out.println("In-Order:");
        bst.inOrder(bst.getRoot());
        System.out.println();

        /*
            Explanation as to why the new node is inserted correctly:

            Based on how we inserted the values, the tree would be like:
                insert(49): 49 is root
                insert(61): 61 > 49, so 61 is 49's right child
                insert(17): 17 < 49, so 17 is 49's left child
                insert(113): 113 > 49, so go to 49's right child -> 113 > 61, so 113 is 61's right child
                insert(27): 27 < 49, so go to 49's left child -> 27 > 17, so 27 is 17's right child
                insert(35): 35 < 49, so go to 49's left child -> 35 > 17, so go to 17's right child
                    -> 35 > 27, so 35 is 27's right child

             From what is displayed from traversals:
                Pre-order (NLR) shows 49 is the root (since it is printed first). It also shows that
                 17 is either 49's left child (correct) or right child.
                In-order (LNR) shows 17 is the leftmost value (since it is printed first). It also shows
                 that 17, 27, and 35, which are all printed before 49, are on 49's left subtree. So 17
                 has to be 49's left child. Likewise, 27 has to either be 17's right child (since 17 is
                 leftmost) or a child of 17's right child. If 27 was a child of 17's right child, however,
                 it would not be printed right after 17 in preOrder traversal. So 27 is 17's right child.
                 Likewise, if 35 was 27's left child, it would be printed before 27 in inOrder traversal,
                 so 35 is 27's right child.
                In-order also shows that 61 and 113, which are both after 49, are on 49's right subtree.
                 Additionally, from both traversals we can see that 113 is the rightmost value. So, we
                 can conclude that 61 is 35's right child, and 113 is 61's right child.

                Therefore, insertion was done correctly

         */

        // deleting Franklin county in tree (fips 49) and displaying tree with pre-order and in-order traversal
        System.out.println(">> Deleting Franklin county from BST");
        bst.delete(49);
        System.out.println("Pre-Order:");
        bst.preOrder(bst.getRoot());
        System.out.println();
        System.out.println("In-Order:");
        bst.inOrder(bst.getRoot());
        System.out.println();

        /*
            Explanation as to why the node is deleted correctly:

            Deleting 49 should go like:
                49 == root, and has two children. 49's left child has a right child so search for 49's
                    in-order predecessor:
                       go 49.left -> 17 -> 17.right.right is not null -> go 17.right -> 27 -> 27.right.right
                       is null -> in-order predecessor is 27.right -> 35
                    35 is deleted from original position in tree and replaces 49's spot.

            New tree should have 35 as root, 17 as 35's left child, 27 as 17's right child, 61 as 35's right
             child, and 113 as 61's right child.

            From what is displayed from traversals (using logic from above explanation):
                Pre-order shows 35 is the root.
                In-order shows that 17 and 27, which are both before 35, are on 35's left subtree,
                 so 17 is 35's left child, and 17's right child is 27. It also shows that 61 and 113,
                 which are both after 35, are on 35's right subtree.
                From both traversals, we can see that 113 is the rightmost value. So, 61 is 35's right
                 child, and 113 is 61's right child.

                So, deletion was done correctly
         */
    }
} // end main