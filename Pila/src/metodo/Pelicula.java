
package metodo;

public class Pelicula {

    private int idPelicula;
    private String nombrePelicula;
    private float duracion;
    private int edad;
    private float valorBoleta;

    public Pelicula() { 
        this.idPelicula = 0;
        this.nombrePelicula = "";
        this.duracion = 0;
        this.edad = 0;
        this.valorBoleta = 0;
    }

    public Pelicula(int idPelicula, String nombrePelicula, float duracion, int edad) {
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.duracion = duracion;
        this.edad = edad;

        if (edad >= 5 && edad <= 10) {
            this.valorBoleta = 3000;

        } else if (edad >= 11 && edad <= 17) {
            this.valorBoleta = 7000;
        } else if (edad >= 18) {
            this.valorBoleta = 10000;
        } else {
            this.valorBoleta = 0;
        }

    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public float getDuracion() {
        return duracion;
    }

    public int getEdad() {
        return edad;
    }

    public float getValorBoleta() {
        return valorBoleta;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
