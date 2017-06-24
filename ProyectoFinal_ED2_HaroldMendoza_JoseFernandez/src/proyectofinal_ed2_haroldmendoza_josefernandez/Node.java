/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_ed2_haroldmendoza_josefernandez;

import java.util.ArrayList;

/**
 *
 * @author Harold Mendoza
 */
public class Node {
    Node father;
    ArrayList<Node> children = new ArrayList();
    int key;
    int id;

    public Node() {
    }

    public Node(Node father, int key, int id) {
        this.father = father;
        this.key = key;
        this.id = id;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" + "father=" + father + ", children=" + children + ", key=" + key + ", id=" + id + '}';
    }
    
    
    
    
    
    
}
