package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private String nombreEquipo;
    private String codigo;
    private LocalDate fechaFundacion;
    private List<Jugador> jugadores;
    private Entrenador entrenador;
    
	public Equipo(String nombreEquipo, String codigo, LocalDate fechaFundacion, List<Jugador> jugadores,
			Entrenador entrenador) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.codigo = codigo;
		this.fechaFundacion = fechaFundacion;
		this.jugadores = new ArrayList<Jugador>();
		this.entrenador = entrenador;
	}
	
	public boolean agregarJugador(Jugador jugador) {
	    if (jugador != null && !jugadores.contains(jugador)) {
	        return jugadores.add(jugador);
	    }
	    return false;
	}
	
	public boolean eliminarJugador(Jugador jugador) {
	    if (jugador != null) {
	        return jugadores.remove(jugador);
	    }
	    return false;
	}
	
	public Jugador traerJugadorPorDorsal(int dorsal) {
	    for (Jugador j : jugadores) {
	        if (j.getDorsal() == dorsal) {
	            return j;
	        }
	    }
	    return null;
	}
	
	public double calcularAlturaPromedio() {
	    if (jugadores.isEmpty()) return 0;

	    double suma = 0;
	    for (Jugador j : jugadores) {
	        suma += j.getAltura();
	    }
	    return suma / jugadores.size();
	}
	
	@Override
    public String toString() {
        return "Equipo [nombre=" + nombreEquipo + ", codigo=" + codigo +
               ", fechaFundacion=" + fechaFundacion +
               ", entrenador=" + entrenador +
               ", jugadores=" + jugadores + "]";
    }

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

}
