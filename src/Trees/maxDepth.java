package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepthTree(Node root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        queue.poll();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentnode = queue.poll();
                for (Node child : currentnode.children)
                    queue.offer(child);
            }
            depth++;
        }
        return depth++;
    }

}
