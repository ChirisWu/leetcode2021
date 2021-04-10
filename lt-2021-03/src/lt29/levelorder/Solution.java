package lt29.levelorder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null){
            return res;
        }
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++){
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n1.left = n9;
        n1.right = n20;
        n20.left = n15;
        n20.right = n7;
        List<List<Integer>> lists = new Solution().levelOrder(n1);
        LinkedList<Integer> list = new LinkedList<>();
        List<int[]> res = new ArrayList<>();
        int[][] ints = res.toArray(new int[res.size()][]);

    }
}



