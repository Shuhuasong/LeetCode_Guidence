package Pramp.Tree;
import java.io.*;
import java.util.*;

/*
Largest Smaller BST Key
Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey
that finds the largest key in the tree that is smaller than num. If such a number doesn’t exist, return -1. Assume
 that all keys in the tree are nonnegative.

Analyze the time and space complexities of your solution.

For example:

For num = 17 and the binary search tree below:
               20
              /  \
             9    25
            / \
           5   12
               /\
              11 14

 Your function would return:

14 since it’s the largest key in the tree that is still smaller than 17.

Constraints:

[time limit] 5000ms
[input] Node rootNode
[output] integer


 */

public class LargestSmallerBST_key {

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

    /*    int findLargestSmallerKey(int num) {
            // your code goes here
            int result = -1;
            while(root!=null){
                if(root.key < num){
                    result = root.key;
                    root = root.right;
                }else{
                    root = root.left;
                }
            }
            return result;
        } */


            int findLargestSmallerKey(int num) {
                // your code goes here
                int max = Integer.MIN_VALUE;

                while (root != null) {
                    if (root.key < num) {
                        max = Math.max(max, root.key);
                    }
                    if (root.key < num) {
                        root = root.right;
                    } else {
                        root = root.left;
                    }
                }
                return max==Integer.MIN_VALUE?-1:max;
            }


            //  inserts a new node with the given number in the
        //  correct place in the tree
        void insert(int key) {

            // 1) If the tree is empty, create the root
            if(this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null) {
                if(key < currentNode.key) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    /*********************************************
     * Driver program to test above function     *
     *********************************************/

    public static void main(String[] args) {

        // Create a Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(10);
        System.out.println("Largest smaller number is " + result);

    }
}
