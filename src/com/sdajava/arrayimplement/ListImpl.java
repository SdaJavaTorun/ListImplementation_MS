package com.sdajava.arrayimplement;

/**
 * Created by RENT on 2017-03-06.
 */

// węzeł, wskazuje na następny, na poprzedni element
public class ListImpl{
        private Node start;
        private Node stop;

        public ListImpl() {  // zerowanie wartości początkowej przy tworzeniu nowego obiektu listy
            this.start = null;
            this.stop = null;
        }


        public void addElement(String value) { // dodanie obiektu klasy węzeł (Node)
            Node node = new Node(value, null, null); // wartość, indeksy przed i za nim
            if (checkIsEmpty()){
                start = node;
                stop = node;
            } else {
                Node pm = start; // dodanie obiektu na koniec
                while (pm != null){
                    pm.getNext();
                    if (pm == start){
                        node.setNext(pm);
                        pm.setPrev(node);
                        start = node;
                        break;
                    } else {
                        node.setNext(pm);
                        node.setPrev(pm.getPrev());
                        pm.getPrev().setPrev(node);
                        pm.setPrev(node);
                        break;
                    }
                }
                if(pm == null){
                    stop.setNext(node);
                    node.setPrev(stop);
                    stop = node;
                }
            }
        }

        public boolean checkIsEmpty(){
            return (start == null);
        }
    }




