package Trees;

public class TreeMain {
    public static void main(String[] args) throws Exception {
        TreeNode tree = new TreeNode(1);
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.right = new TreeNode(8);
        tree.root.right.right = new TreeNode(15);
        tree.root.right.left = new TreeNode(12);
        tree.root.right.right.left = new TreeNode(14);

        tree.leftView();
        System.out.println();
        System.out.println("Height of the tree is : "+ tree.maxDepth(tree));
        System.out.println("Size of the tree is : "+tree.size(tree));
        tree.diameterOfBinaryTree(tree);

    }
}
