import com.sun.source.tree.Tree;
import org.apache.commons.math3.util.Pair;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class VerticalPrintTree {
    public void printVerticalOrder(TreeNode root) {
        if (root == null)
            return;

        // TreeMap to store columns and corresponding nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // Queue for level order traversal
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // Initial column is 0

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            // Update the map with current node's value
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }
            map.get(column).add(node.val);

            // Traverse left child if exists
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, column - 1));
            }

            // Traverse right child if exists
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }

        // Print values based on columns
        for (List<Integer> list : map.values()) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        VerticalPrintTree testObj = new VerticalPrintTree();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.right = six;
        testObj.printVerticalOrder(one);
    }
}
