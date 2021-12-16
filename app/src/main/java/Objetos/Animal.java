package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Animal {
    private int id;
    private String[] animal ={"Domestico","Salvaje","Otro"};
    private int costo[] = {25000, 45000, 18000};

    public Animal()
    {

    }

    public Animal(int id, String[] animal, int[] costo) {
        this.id = id;
        this.animal = animal;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAnimal() {
        return animal;
    }

    public void setAnimal(String[] animal) {
        this.animal = animal;
    }

    public int[] getCosto() {
        return costo;
    }

    public void setCosto(int[] costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal1 = (Animal) o;
        return id == animal1.id && Arrays.equals(animal, animal1.animal) && Arrays.equals(costo, animal1.costo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(animal);
        result = 31 * result + Arrays.hashCode(costo);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal=" + Arrays.toString(animal) +
                ", costo=" + Arrays.toString(costo) +
                '}';
    }
}
