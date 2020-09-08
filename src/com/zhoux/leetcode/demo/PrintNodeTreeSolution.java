package com.zhoux.leetcode.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author:zhouxiang
 * @date:2020-06-13
 * @describe:
 * @status:
 */
public class PrintNodeTreeSolution {

    static class Node {

        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public Node(int id) {
            this.id = id;
        }
    }

    public void print(List<Node> list) {
        if (null == list || list.size() == 0) {
            return;
        }
        HashMap<Integer, Node> map = new HashMap<>(list.size());
        for (Node node : list) {
            map.put(node.id, node);
        }
        find(list, map, 0, new Node(0));
    }

    private void find(List<Node> list, HashMap<Integer, Node> map, int level, Node parentNode) {
        Node printNode = null;
        for (Node node : list) {
            if (parentNode.id == node.parentId) {
                doPrint(node.name, level);
                map.remove(node.id);
                find(list, map, level + 1, node);
            }
        }
    }

    private void doPrint(String name, int level) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < level; i++) {
            str.append("\t");
        }
        str.append(name);

        System.out.println(str);
    }

    public static void main(String[] args) {
//        doPrint("test",3);
        List<Node> list = new ArrayList<>();
        list.add(new Node(1, 0, "AA"));
        list.add(new Node(2, 1, "BB"));
        list.add(new Node(3, 1, "CC"));
        list.add(new Node(4, 3, "DD"));
        list.add(new Node(5, 3, "EE"));
        list.add(new Node(6, 2, "FF"));
        list.add(new Node(7, 2, "GG"));
        list.add(new Node(8, 4, "HH"));
        list.add(new Node(9, 5, "II"));

        PrintNodeTreeSolution solution = new PrintNodeTreeSolution();
        solution.print(list);

    }

}
