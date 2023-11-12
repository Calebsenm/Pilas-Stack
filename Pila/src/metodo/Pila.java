
package metodo;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Pila {
    Stack<Pelicula> pila;

    Pila() {
        pila = new Stack();
    }

    void Push(Pelicula data) {
        int pos = pila.indexOf(data);
        // Si el cliente no existe es agregado
        if (pos == -1) {
            pila.push(data);
            JOptionPane.showMessageDialog(null,
                    "Elemento registrado!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "El cliente ya se encuentra registrado!");
        }
    }

    public void Pop() {
        if (!pila.empty()) {
            pila.pop();
            JOptionPane.showMessageDialog(null,
                    "Elemento atendido!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "La pila no tiene elementos!");
        }
    }

    public Pelicula getInfoClienteid(int id) {
        Pelicula auxiliar = new Pelicula();
        int i = 0;

        while (i < pila.size()) {

            auxiliar = (Pelicula) pila.get(i);
            if (auxiliar.getIdPelicula() == id) {
                return auxiliar;
            }

            i++;
        }
        auxiliar = null;
        return auxiliar;
    }

    public int Size(){
        return pila.size();
    }

    public boolean isEmpty(){
        return pila.isEmpty();
    }

    //to estring 
    public String toString(){
    
        String cadena = "";

        for(int i = 0; i < pila.size(); i++){
            cadena += pila.get(i).toString() + "\n";
        }
        return cadena;
    }

}
