package modelos;

import java.time.LocalDate;

public class Entrenador extends Persona {
	
	private String estrategia;
	
	public Entrenador(String nombre, String apellido, long dni, LocalDate fechaNac, String estrategia) {
        super(nombre, apellido, dni, fechaNac);
        this.estrategia = estrategia;
    }
	
	public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public String toString() {
        return "Entrenador [nombre=" + getNombre() + ", apellido=" + getApellido() +
                ", dni=" + getDni() + ", fechaNac=" + getFechaNac() +
                ", estrategia=" + estrategia + "]";
    }
	
	
	
	

}
