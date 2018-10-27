/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

/**
 *
 * @author Broken
 */
public class Node {
    public int Key;

    public Node RightChild, LeftChild,Parent;

    public Node(int key){
        Key = key;
        Parent=null;
        RightChild = null;
        LeftChild = null;
    }
}