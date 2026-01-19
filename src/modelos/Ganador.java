package modelos;

import java.time.LocalDate;

public class Ganador {
	
	private LocalDate fecha;
    private Equipo equipoGanador;
    private int cantidadGoles;

    public Ganador(LocalDate fecha, Equipo equipoGanador, int cantidadGoles) {
        this.fecha = fecha;
        this.equipoGanador = equipoGanador;
        this.cantidadGoles = cantidadGoles;
    }

    @Override
    public String toString() {
        return "Ganador [fecha=" + fecha + 
               ", equipo=" + equipoGanador.getNombreEquipo() +
               ", goles=" + cantidadGoles + "]";
    }

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Equipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public int getCantidadGoles() {
		return cantidadGoles;
	}

	public void setCantidadGoles(int cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}
    
    

}
