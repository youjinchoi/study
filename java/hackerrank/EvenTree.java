package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/even-tree/problem
* */
public class EvenTree {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	static int removedEdges = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        for(int tree_i = 0; tree_i < m; tree_i++){
        		int child = in.nextInt();
        		int parent = in.nextInt();
        		ArrayList<Integer> list = map.get(parent);
        		if (list == null) {
        			list = new ArrayList<Integer>();
        		}
        		list.add(child);
        		map.put(parent, list);
        }
        traverse(1);
        System.out.println(removedEdges);
        in.close();
    }
    
    static void traverse(int root) {
    		ArrayList<Integer> childList = map.get(root);
    		if (childList == null || childList.size() == 0) {
    			return;
    		}
        for (Integer child : childList) {
        		int num = getNodeCount(child);
        		if (num % 2 == 0) {
        			removedEdges++;
        		}
        		traverse(child);
        }
    }
    
    static int getNodeCount(int root) {
    		int count = 0;
    		ArrayList<Integer> list = map.get(root);
    		if (list == null || list.size() == 0) {
    			return 1;
    		}
    		for (Integer i : list) {
    			count += getNodeCount(i);
    		}
    		return count + 1;
    }
}