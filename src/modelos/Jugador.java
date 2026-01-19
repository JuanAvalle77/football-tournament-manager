package modelos;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Jugador extends Persona {
	
	private float altura;
    private float peso;
    private String posicion;
    private int dorsal;
    private List<EstadisticaJugador> estadisticas;
    
	public Jugador(String nombre, String apellido, long dni, LocalDate fechaNac,
            float altura, float peso, String posicion, int dorsal) {
		super(nombre, apellido, dni, fechaNac);
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.estadisticas = new ArrayList<EstadisticaJugador>();
	}
	
	public boolean agregarEstadistica(EstadisticaJugador estadistica) {
	    if (estadistica != null) {
	        return estadisticas.add(estadistica);
	    }
	    return false;
	}
	
	public boolean eliminarEstadistica(EstadisticaJugador estadistica) {
	    if (estadistica != null) {
	        return estadisticas.remove(estadistica);
	    }
	    return false;
	}
	
	public EstadisticaJugador traerEstadisticaPorPartido(int idPartido) {
	    for (EstadisticaJugador est : estadisticas) {
	        if (est.getPartido().getIdPartido() == idPartido) {
	            return est;
	        }
	    }
	    return null;
	}

	public float getAltura() { return altura; }
    public void setAltura(float altura) { this.altura = altura; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public List<EstadisticaJugador> getEstadisticas() { return estadisticas; }
    public void setEstadisticas(List<EstadisticaJugador> estadisticas) { this.estadisticas = estadisticas; }

    @Override
    public String toString() {
        return "Jugador [nombre=" + getNombre() + ", apellido=" + getApellido() +
                ", dni=" + getDni() + ", fechaNac=" + getFechaNac() +
                ", altura=" + altura + ", peso=" + peso +
                ", posicion=" + posicion + ", dorsal=" + dorsal +
                ", estadisticas=" + estadisticas + "]";
    }
    
}
