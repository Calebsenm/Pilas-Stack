
package metodo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*

1.	Registrar una película en la pila.

2.	Mostrar los próximos estrenos dado los N estrenos que se desean ver: es decir,
    deberá solicitar al usuario cuantos próximos estrenos desea ver y esto mostrar la 
    información de cada película desde el tope de la Pila.  Esta información podrá ser
    almacenada en un archivo.

3.	Mostrar los estrenos antiguos dado los N estrenos que se desean ver: 
    es decir, deberá solicitar al usuario cuantos estrenos antiguos desea ver 
    y esto mostrar la información de cada película desde la base 
    (primer elemento agregado, ojo esto implica que no es desde el tope) de la Pila.
    Esta información podrá ser almacenada en un archivo.

4.	Totales por categoría (para ello primero deberá especificar 
    la categoría: Niños, Adolescentes o Adultos – recuerde que esto se determina 
    de acuerdo al valor de boleta pagado): y para la categoría seleccionada mostrar 
    promedio recaudo y total recaudado.

5.	Dada una categoría (Niños, Adolescentes o Adultos) eliminar la información 
    del objeto de la Pila (Stack) de la categoría seleccionada.

6.	Salir.

*/

public class Principal {

    Pila pila = new Pila();

    public void RegirtrarPelicula(Pelicula pelicula) {
        pila.Push(pelicula);
    }

    public void mostrarProximosEstrenos(int n) throws IOException {

        if (n <= 0 || n > pila.Size() ) {
            System.out.println("La cantidad ingresada no es válida.");
            return;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("ProximosEstrenos.txt"));
        Pila pelicula = pila;

        for (int i = 0; i < n; i++) {
                if (!pila.isEmpty()) {
                    pelicula.Pop();
                    writer.write(pelicula.toString());
                    writer.newLine();
                } else {
                    System.out.println("No hay más estrenos en la pila.");
                    break;
                }
            }
        
    }

    public void mostrarEstrenosAntiguos(int n) throws IOException {
        if (n <= 0 || n > pila.Size()) {
            System.out.println("La cantidad ingresada no es válida.");
            return;
        }
    
        BufferedWriter writer = new BufferedWriter(new FileWriter("EstrenosAntiguos.txt"));
            System.out.println("Estrenos Antiguos:");
            Pila pilaCopia = pila;

            int totalElementos = pilaCopia.Size();
            int elementosMostrados = 0;
    
            while (elementosMostrados < n && elementosMostrados < totalElementos) {
                
                pilaCopia.Pop();
               
                writer.write(pilaCopia.toString());
                writer.newLine();
                elementosMostrados++;
            }
    
            if (elementosMostrados == 0) {
                System.out.println("No hay estrenos antiguos en la pila.");
            }
    }

    public String TotalesPorCategoria(String categoria) {
        float totalRecaudado = 0;
        int cantidadPeliculas = 0;
        String cadena = "";

        Pila pilaCopia = pila; 
       
        while (!pilaCopia.isEmpty()) {
            Pelicula pelicula = pilaCopia.pila.pop();

            if (categoria.equalsIgnoreCase("Niños") && pelicula.getValorBoleta() == 3000) {
                totalRecaudado += pelicula.getValorBoleta();
                cantidadPeliculas++;
            } else if (categoria.equalsIgnoreCase("Adolescentes") && pelicula.getValorBoleta() == 7000) {
                totalRecaudado += pelicula.getValorBoleta();
                cantidadPeliculas++;
            } else if (categoria.equalsIgnoreCase("Adultos") && pelicula.getValorBoleta() == 9000) {
                totalRecaudado += pelicula.getValorBoleta();
                cantidadPeliculas++;
            }
        }
    
        if (cantidadPeliculas > 0) {
            float promedioRecaudo = totalRecaudado / cantidadPeliculas;

             cadena += "Categoría: " + categoria + "\n" 
                    + "Total recaudado: " + totalRecaudado + "\n"
                    + "Cantidad De peliculas" + cantidadPeliculas + "\n"
                    + "Promedio Recaudo: " + promedioRecaudo + "\n";
          
           
        } else {
            cadena = "No hay películas en la categoría especificada.";
        }   

        return   cadena ;
    }

    public void EliminarPelicula(String categoria) {
        Pila pilaAuxiliar = new Pila();

       
        while (!pila.isEmpty()) {
            Pelicula pelicula = pila.pila.pop();
            if (!(categoria.equalsIgnoreCase("Niños") && pelicula.getValorBoleta() == 3000) &&
                    !(categoria.equalsIgnoreCase("Adolescentes") && pelicula.getValorBoleta() == 7000) &&
                    !(categoria.equalsIgnoreCase("Adultos") && pelicula.getValorBoleta() == 9000)) {
                // Si no pertenece a la categoría especificada, se agrega a la pila auxiliar
                pilaAuxiliar.pila.push(pelicula);
            }
        }

        // Revertir la pila auxiliar para mantener el orden original
        while (!pilaAuxiliar.isEmpty()) {
            pila.pila.push(pilaAuxiliar.pila.pop());
        }

        System.out.println("Películas de la categoría " + categoria + " eliminadas correctamente.");
    }

    public void Salir() {
        System.exit(0);
    }

}