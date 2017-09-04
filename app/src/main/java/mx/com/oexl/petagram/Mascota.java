package mx.com.oexl.petagram;



public class Mascota {
    private String nombre;
    private String numero;
    private int foto;
    private int huesoB;
    private int huesoA;

    public Mascota(int foto, int huesoB, String nombre, String numero, int huesoA){
        this.foto = foto;
        this.nombre = nombre;
        this.numero = numero;
        this.huesoB = huesoB;
        this.huesoA = huesoA;

    }

    public int getHuesoB() {
        return huesoB;
    }

    public void setHuesoB(int huesoB) {
        this.huesoB = huesoB;
    }

    public int getHuesoA() {
        return huesoA;
    }

    public void setHuesoA(int huesoA) {
        this.huesoA = huesoA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public int getFoto() {
        return foto;
    }
}