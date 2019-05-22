package com.bt.impl;

public class BTUtil {
	
	private static <T> boolean search(Node<T> r, T x) {
		if(r == null){ return false; }
		if(r.data ==x)
			return true;

		boolean a = search(r.left, x);
		boolean b = search(r.right, x);
		return (a||b);
	}
	
	public static <T> int size(Node<T> node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}
	
	public static <T> int maxDepth(Node<T> node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	} 
  
    /* Print nodes at the given level */
    public static <T> void printGivenLevel (Node<T> root ,int level) { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        }
    }
	
	public static <T> Node<T> mirror(Node<T> node) { 
        if (node == null) 
            return node; 
        /* do the subtrees */
        Node<T> left = mirror(node.left); 
        Node<T> right = mirror(node.right); 
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left;
        return node; 
    }
	
	public static <T> boolean isBSTUtil(Node<T> node, int min, int max) { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
 
        /* false if this node violates the min/max constraints */
        if ( (Integer) node.data < min ||  (Integer) node.data > max) 
            return false; 
  
        /* otherwise check the subtrees recursively tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, (Integer) node.data  -1) && 
                isBSTUtil(node.right, (Integer) node.data + 1, max)); 
    }

	public static <T> int getLeafCount(Node<T> node) { 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return 1; 
        else
            return getLeafCount(node.left) + getLeafCount(node.right); 
    }
}