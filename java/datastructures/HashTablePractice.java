package datastructures;

import java.util.LinkedList;

public class HashTablePractice {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("youjin", "is pretty");
        h.put("eugene", "is beautiful");
        h.put("yj", "is smart");
        System.out.println(h.get("youjin"));
        System.out.println(h.get("eugene"));
        System.out.println(h.get("yj"));
        System.out.println(h.get("choi"));
    }
}

class HashTable {
    class Node {
        String key;
        String value;
        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
        String getValue() {
            return value;
        }
        void setValue(String value) {
            this.value = value;
        }
    }

    java.util.LinkedList<Node>[] data;

    HashTable(int size) {
        this.data = new java.util.LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? null : node.value;
    }
}
