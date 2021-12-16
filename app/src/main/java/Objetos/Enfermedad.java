package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Enfermedad {
    private int id;
    private String[] enfermedad ={"Brucelosis","Fiebre Aftosa","Salmonella", "Rabia"};
    private int precio[] = {75000, 22500, 35000, 54000};

    public Enfermedad()
    {

    }

    public Enfermedad(int id, String[] animal, int[] costo) {
        this.id = id;
        this.enfermedad = enfermedad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enfermedad that = (Enfermedad) o;
        return id == that.id && Arrays.equals(enfermedad, that.enfermedad) && Arrays.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(enfermedad);
        result = 31 * result + Arrays.hashCode(precio);
        return result;
    }

    @Override
    public String toString() {
        return "Enfermedad{" +
                "id=" + id +
                ", enfermedad=" + Arrays.toString(enfermedad) +
                ", precio=" + Arrays.toString(precio) +
                '}';
    }
}
