/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_ed2_haroldmendoza_josefernandez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Harold Mendoza
 */
public class ArbolB {

    ArrayList<Node> root = new ArrayList();
    int orden;
    int keySize; //cuantos nodos pueden haber en un slot, que es el orden -1

    public ArbolB(int orden) {
        this.orden = orden;
        this.keySize = orden - 1;
    }

    public ArbolB() {
    }

    public ArrayList<Node> getRoot() {
        return root;
    }

    public void setRoot(ArrayList<Node> root) {
        this.root = root;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keys) {
        this.keySize = keys;
    }

    //======================================ADD NODE AL ARBOLB========================
    public boolean addNodeTree(int id, int key) {
        boolean seInserto = false;

        //======================Vericar si el root tiene hijos==================//
        Node nuevo = new Node(id, key); //creamos el nuevo nodo
        boolean NodeGoesLeftSon = false;
        boolean NodeGoesRightSon = false;
        Node hasLeftAuxNode = null;
        Node hasRightAuxNode = null;
        for (Node node : root) {
            if (node.getId() < nuevo.getId()) {
                if (node.hasLeftSon) {
                    NodeGoesLeftSon = true;
                    hasLeftAuxNode = node;
                    break;
                }
            } else if (node.getId() > nuevo.getId()) {
                if (node.hasRightSon) {
                    NodeGoesRightSon = true;
                    hasRightAuxNode = node;
                    break;
                }
            }//fin else if
        }//fin for e

        //=========Verificar si insertar en el left son, right son, o hacer split=====//
        if (NodeGoesLeftSon) {
            for (Node node : root) {
                if (hasLeftAuxNode.equals(node)) {
                    ArbolB tree = new ArbolB(orden);
                    tree.setRoot(node.getLeftchildren());
                    tree.addNodeTree(nuevo.getId(), nuevo.getKey());
                    seInserto = true;
                    break;
                }
            }
        } else if (NodeGoesRightSon) {
            for (Node node : root) {
                if (hasRightAuxNode.equals(node)) {
                    ArbolB tree = new ArbolB(orden);
                    tree.setRoot(node.getRightchildren());
                    tree.addNodeTree(nuevo.getId(), nuevo.getKey());
                    seInserto = true;
                    break;
                }
            }
        } else if (root.size() == keySize) {//verifica si la root esta llena
            nuevo = new Node(id, key); //creamos el nuevo nodo
            splitAndInsert(nuevo);
            seInserto = true;
        } else { //si el arrayList aun no se ha llenado
            root.add(new Node(id, key));
            sort();
            seInserto = true;
        }

        return seInserto;
    }

    //================================SPLIT AND INSERT=============================
    public void splitAndInsert(Node nuevo) {
        ArrayList<Node> temp = root;
        temp.add(nuevo);
        ArrayList<Node> temp2 = new ArrayList();
        temp2 = sortOtherArrays(temp);
        int pos = (temp2.size() / 2);
        if (pos % 2 != 0) { //obtener la mediana para hacer el split correspondiente
            pos++;
        }
        Node newFather = temp2.get(pos); //se establece quien sera el nuevo padre de todos
        //Se declaran los hijos del nodo padre
        for (int i = 0; i < temp2.size(); i++) {
            if (i < pos) {//hijo menor
                temp2.get(i).setFather(newFather);
                newFather.setLeftchildren(temp2.get(i));
            } else if (i > pos) {//hijo mayor
                temp2.get(i).setFather(newFather);
                newFather.setRightchildren(temp2.get(i));
            }
        }
        root = new ArrayList(); //se resetea el arraylist de root
        root.add(newFather); //se setea el neo father al root como 

    }

    //============================SORT OTHER ARRAYS========================================
    public ArrayList<Node> sortOtherArrays(ArrayList temp) { //se realiza el sort del arrayList para el split
        Collections.sort(temp, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                String id1 = o1.getId() + "";
                String id2 = o2.getId() + "";
                return id2.compareTo(id1);
            }
        });
        return temp;
    }

    //==========================================SORT PRINCIPAL (HACE SORT SOLAMENTE AL ROOT)===============================
    public void sort() {  //ordena los nodos en el root de menor a mayor
        // Sorting
        Collections.sort(root, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                String id1 = o1.getId() + "";
                String id2 = o2.getId() + "";
                return id2.compareTo(id1);
            }
        });
    }

    //================================DELETE A NODE DEL ARBOL B=============================
    public boolean deleteNodeTree() {
        boolean seBorro = false;

        return seBorro;

    }

}
