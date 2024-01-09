package Trees;
import java.util.*;
public class Leetcode {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(currentLevel);
        }
        return list;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double average = levelSum / levelSize;
            list.add(average);
        }
        return list;
    }

    public static TreeNode successor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            if (currentNode.val == key) break;
        }
        return queue.peek();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (!flag) {
                    TreeNode current = deque.pollFirst();
                    list.add(current.val);
                    if (current.left != null) deque.addLast(current.left);
                    if (current.right != null) deque.addLast(current.right);
                } else {
                    TreeNode current = deque.pollLast();
                    list.add(current.val);
                    if (current.right != null) deque.addFirst(current.right);
                    if (current.left != null) deque.addFirst(current.left);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode current = deque.poll();
                list.add(current.val);
                if (current.left != null) deque.offer(current.left);
                if (current.right != null) deque.offer(current.right);
            }
            result.addFirst(list);
        }
        return result;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Node leftMost = root;
            while (leftMost.left != null) {
                Node current = leftMost;
                while (current != null) {
                    current.left.next = current.right;
                    if (current.next != null) {
                        current.right.next = current.next.left;
                    }
                    current = current.next;
                }
                leftMost = leftMost.left;
            }
            return root;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int level = deque.size();
            for (int i = 0; i < level; i++) {
                TreeNode current = deque.poll();
                list.add(current.val);
                if (i == level - 1) list.add(current.val);
                if (current.left != null) {
                    deque.offer(current.left);
                }
                if (current.right != null) {
                    deque.offer(current.right);
                }
            }
        }
        return list;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int level = deque.size();
            boolean foundX = false;
            boolean foundY = false;
            for (int i = 0; i < level; i++) {
                TreeNode current = deque.poll();
                if (current.val == x) foundX = true;
                if (current.val == y) foundY = true;

                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                            (current.right.val == x && current.left.val == y)) {
                        return false;
                    }
                }
                if (current.left != null) deque.offer(current.left);
                if (current.right != null) deque.offer(current.right);
            }
            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;
    }

    // DFS problems

    public static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    public static int helper(TreeNode node){
        if(node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        diameter = Math.max(diameter, l + r + 1);
        return Math.max(l,r) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public int maxDepth(TreeNode root) {
        return root != null ? Math.max(maxDepth(root.left),maxDepth(root.right)) + 1 : 0;
    }

    int[] nums;
    private TreeNode f(int s, int e){
        if(s > e) return null;
        int mid = s + (e-s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = f(s, mid - 1);
        root.right = f(mid + 1, e);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return f(0, nums.length-1);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        while(node != null){
            if(node.left != null){
                TreeNode rightMost = node.left;
                while(rightMost.right != null) rightMost = rightMost.right;
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        ArrayList<Integer> a = new ArrayList<>();
        function(root, a);
        return a.get(k - 1);
    }
    public static void function(TreeNode root, ArrayList<Integer> a){
        if(root == null) return;
        a.add(root.val);
        function(root.left, a);
        function(root.right, a);
    }

    static int index;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return h(preorder, 0, preorder.length);
    }
    private static TreeNode h(int[] preorder, int lo, int hi){
        if(lo > hi) return null;
        int rootValue = preorder[index++];
        TreeNode root = new TreeNode(rootValue);
        root.left = h(preorder, lo, map.get(rootValue) - 1);
        root.right = h(preorder, map.get(rootValue) + 1, hi);
        return root;
    }

    public TreeNode buildTreePostOrder(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        if(postorder.length == 1) return root;
        for(int val : inorder){
            if(val == root.val) break;
            index++;
        }
        root.left = buildTreePostOrder(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTreePostOrder(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index + 1, postorder.length - 1));
        return root;
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        Deque<TreeNode> deque = new ArrayDeque<>();
        StringBuilder string = new StringBuilder();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode current = deque.poll();
            if(current == null){
                string.append("n");
                continue;
            }
            string.append(current.val).append(" ");
            deque.add(current.left);
            deque.add(current.right);
        }
        return string.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        deque.add(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode current = deque.poll();
            if(!str[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                current.left = left;
                deque.add(left);
            }
            if(!str[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                current.right = right;
                deque.add(right);
            }
        }
        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        HashSet<Integer> set = new HashSet<>();
        pathSumHelper(root, 0, set);
        return root != null && set.contains(targetSum);
    }
    public static void pathSumHelper(TreeNode node, int sum, HashSet<Integer> set) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            set.add(sum);
        } else {
            pathSumHelper(node.left, sum, set);
            pathSumHelper(node.right, sum, set);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumTwo(root, 0, new ArrayList<>(), result, targetSum);
        return result;
    }
    public static void pathSumTwo(TreeNode node, int sum, List<Integer> list, List<List<Integer>> result, int targetSum){
        if(node == null) return;
        list.add(node.val);
        sum += node.val;
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(list));
            }
        }
        else{
            pathSumTwo(node.left, sum, list, result, targetSum);
            pathSumTwo(node.right, sum, list, result, targetSum);
        }
        list.removeLast();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    static int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sum;
    }
    public static void sumNumbersHelper(TreeNode node, int currentSum){
        if(node == null) return;
        currentSum = currentSum * 10 + node.val;
        if(node.left == null && node.right == null){
            sum += currentSum;
        }
        sumNumbersHelper(node.left, currentSum);
        sumNumbersHelper(node.right, currentSum);
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helperMaxPathSum(root);
        return ans;
    }
    public int helperMaxPathSum(TreeNode node){
        if(node == null) return 0;

        int left = helperMaxPathSum(node.left);
        int right = helperMaxPathSum(node.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        ans = Math.max(ans, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
