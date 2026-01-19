package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	
	private int idPartido;                     
    private LocalDate fecha;
    private String estadio;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private List<EstadisticaJugador> estadisticas;
    
    public Partido(LocalDate fecha, String estadio, Equipo equipoLocal, 
            Equipo equipoVisitante, int idPartido) {
    	this.fecha = fecha;
    	 this.estadio = estadio;
    	 this.equipoLocal = equipoLocal;
    	 this.equipoVisitante = equipoVisitante;
    	 this.idPartido = idPartido;
    	 this.estadisticas = new ArrayList<>();
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
    
    public EstadisticaJugador traerEstadisticaPorIndex(int index) {
        if (index >= 0 && index < estadisticas.size()) {
            return estadisticas.get(index);
        }
        return null;
    }
    
    public int getGolesEquipoLocal() {
        int goles = 0;
        for (EstadisticaJugador est : estadisticas) {
            if (equipoLocal.getJugadores().contains(est.getJugador())) {
                goles += est.getCantGoles();
            }
        }
        return goles;
    }

    public int getGolesEquipoVisitante() {
        int goles = 0;
        for (EstadisticaJugador est : estadisticas) {
            if (equipoVisitante.getJugadores().contains(est.getJugador())) {
                goles += est.getCantGoles();
            }
        }
        return goles;
    }

	
    public int getIdPartido() { return idPartido; }
    public void setIdPartido(int idPartido) { this.idPartido = idPartido; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstadio() { return estadio; }
    public void setEstadio(String estadio) { this.estadio = estadio; }

    public Equipo getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(Equipo equipoLocal) { this.equipoLocal = equipoLocal; }

    public Equipo getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(Equipo equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public List<EstadisticaJugador> getEstadisticas() { return estadisticas; }
    public void setEstadisticas(List<EstadisticaJugador> estadisticas) { this.estadisticas = estadisticas; }

    @Override
    public String toString() {
        return "Partido [id=" + idPartido + ", fecha=" + fecha +
               ", estadio=" + estadio + ", local=" + equipoLocal.getNombreEquipo() +
               ", visitante=" + equipoVisitante.getNombreEquipo() +
               ", estadisticas=" + estadisticas + "]";
    }
}
