package main.java.com.obinnaogbonna.dsAlg;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeImpls {

    public static BinTreeNode getBinTreeNode() {
        BinTreeNode root = new BinTreeNode(3);
        root.left = new BinTreeNode(4);
        root.right = new BinTreeNode(5);
        root.right.left = new BinTreeNode(6);
        root.right.right = new BinTreeNode(7);
        root.right.left.left = new BinTreeNode(8);
        root.right.left.right = new BinTreeNode(9);
        root.right.right.right = new BinTreeNode(10);
        return root;
    }

    public static void topView(BinTreeNode root) {
        class QueueObj {
            BinTreeNode node;
            int hd;
            QueueObj(BinTreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, BinTreeNode> map = new TreeMap<>();
        queue.offer(new QueueObj(root, 0));
        while(!queue.isEmpty()) {
            QueueObj cur = queue.poll();
            if(cur != null) {
                if(!map.containsKey(cur.hd))
                    map.put(cur.hd, cur.node);
                if(cur.node.left != null)
                    queue.offer(new QueueObj(cur.node.left, cur.hd - 1));
                if(cur.node.right != null)
                    queue.offer(new QueueObj(cur.node.right, cur.hd + 1));
            }
        }
        for(Map.Entry<Integer, BinTreeNode>item : map.entrySet()) {
            System.out.print(item.getValue().data + " ");
        }
    }


    public static void main(String[] args) {
        
        BinTreeNode root = getBinTreeNode();
        topView(root);
    }
}