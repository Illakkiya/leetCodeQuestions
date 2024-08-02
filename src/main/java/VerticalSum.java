import java.util.TreeMap;

class VerticalSum {
    // Function to find the sum of all nodes in a binary tree which was divided vertically
    public static void verticalSum(TreeNode root) {
        // A TreeMap is used to store the sum of nodes for each vertical level
        TreeMap<Integer, Integer> map = new TreeMap<>();
        calculateVerticalSum(root, map, 0);

        // Print the sum of nodes for each vertical level
        for (int sum : map.values()) {
            System.out.println(sum);
        }
    }

    // Recursive function to calculate the sum of nodes for each vertical level
    private static void calculateVerticalSum(TreeNode root, TreeMap<Integer, Integer> map, int level) {
        if (root == null) return;

        // Update the sum for the current vertical level
        map.put(level, map.getOrDefault(level, 0) + root.val);

        // Traverse left and right subtrees with updated vertical level
        calculateVerticalSum(root.left, map, level - 1);
        calculateVerticalSum(root.right, map, level + 1);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Vertical sums of the binary tree:");
        verticalSum(root);
    }
}
