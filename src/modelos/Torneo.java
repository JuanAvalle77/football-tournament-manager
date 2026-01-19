package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	
	private String nombreTorneo;
    private String temporada;
    private List<Equipo> equipos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int idTorneo;
    private List<Partido> partidos;

    
	public Torneo(String nombreTorneo, String temporada, List<Equipo> equipos, List<Partido> partidos, LocalDate fechaInicio,
			LocalDate fechaFin, int idTorneo) {
		super();
		this.nombreTorneo = nombreTorneo;
		this.temporada = temporada;
		this.equipos = new ArrayList<Equipo>();
		this.partidos = new ArrayList<Partido>();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idTorneo= idTorneo;
	}
    
	public boolean agregarEquipo(Equipo equipo) {
	    if (equipo != null && !equipos.contains(equipo)) {
	        return equipos.add(equipo);
	    }
	    return false;
	}
	
	public boolean eliminarEquipo(Equipo equipo) {
	    if (equipo != null) {
	        return equipos.remove(equipo);
	    }
	    return false;
	}
	
	public boolean agregarPartido(Partido partido) {
	    if (partido != null && !partidos.contains(partido)) {
	        return partidos.add(partido);
	    }
	    return false;
	}

	public boolean eliminarPartido(Partido partido) {
	    if (partido != null) {
	        return partidos.remove(partido);
	    }
	    return false;
	}
	
	public List<Ganador> traerGanadoresPorFecha(LocalDate fecha) {
	    List<Ganador> ganadores = new ArrayList<>();

	    for (Partido p : partidos) {
	        if (p.getFecha().isEqual(fecha)) {
	            int golesLocal = p.getGolesEquipoLocal();
	            int golesVisitante = p.getGolesEquipoVisitante();

	            if (golesLocal > golesVisitante) {
	                ganadores.add(new Ganador(p.getFecha(), p.getEquipoLocal(), golesLocal));
	            } else if (golesVisitante > golesLocal) {
	                ganadores.add(new Ganador(p.getFecha(), p.getEquipoVisitante(), golesVisitante));
	            }
	            
	        }
	    }

	    return ganadores;
	}


	
	public Equipo traerEquipoPorCodigo(String codigo) {
	    for (Equipo e : equipos) {
	        if (e.getCodigo().equalsIgnoreCase(codigo)) {
	            return e;
	        }
	    }
	    return null;
	}
	
	public Equipo equipoConMayorAlturaPromedio() {
	    if (equipos.isEmpty()) return null;

	    Equipo mayor = equipos.get(0);
	    double maxPromedio = mayor.calcularAlturaPromedio();

	    for (Equipo e : equipos) {
	        double promedio = e.calcularAlturaPromedio();
	        if (promedio > maxPromedio) {
	            maxPromedio = promedio;
	            mayor = e;
	        }
	    }
	    return mayor;
	}
	
	public int calcularPuntosEquipo(Equipo equipo) {
	    int puntos = 0;

	    for (Partido p : partidos) {
	        int golesLocal = p.getGolesEquipoLocal();
	        int golesVisitante = p.getGolesEquipoVisitante();

	        if (p.getEquipoLocal().equals(equipo)) {
	            if (golesLocal > golesVisitante) {
	                puntos += 3; 
	            } else if (golesLocal == golesVisitante) {
	                puntos += 1; 
	            }
	        } else if (p.getEquipoVisitante().equals(equipo)) {
	            if (golesVisitante > golesLocal) {
	                puntos += 3; 
	            } else if (golesVisitante == golesLocal) {
	                puntos += 1; 
	            }
	        }
	    }

	    return puntos;
	}
	
	
	public List<String> generarTablaPosiciones() {
	    List<String> tabla = new ArrayList<>();

	    for (Equipo e : equipos) {
	        int puntos = calcularPuntosEquipo(e);
	        tabla.add(e.getNombreEquipo() + " - " + puntos + " pts");
	    }

	    
	    tabla.sort((p1, p2) -> {
	        int puntos1 = Integer.parseInt(p1.split(" - ")[1].replace(" pts", ""));
	        int puntos2 = Integer.parseInt(p2.split(" - ")[1].replace(" pts", ""));
	        return Integer.compare(puntos2, puntos1);
	    });

	    return tabla;
	}
	

	public int calcularGolesJugador(Jugador jugador) {
	    int totalGoles = 0;

	    for (Partido p : partidos) {
	        for (EstadisticaJugador est : p.getEstadisticas()) {
	            if (est.getJugador().equals(jugador)) {
	                totalGoles += est.getCantGoles();
	            }
	        }
	    }

	    return totalGoles;
	}
	
	
	public int calcularAsistenciasJugador(Jugador jugador) {
	    int totalAsistencias = 0;

	    for (Partido p : partidos) {
	        for (EstadisticaJugador est : p.getEstadisticas()) {
	            if (est.getJugador().equals(jugador)) {
	                totalAsistencias += est.getCantAsistencias();
	            }
	        }
	    }

	    return totalAsistencias;
	}
	
	
	public List<String> generarTablaGoleadores() {
	    List<String> tabla = new ArrayList<>();

	    for (Equipo e : equipos) {
	        for (Jugador j : e.getJugadores()) {
	            int goles = calcularGolesJugador(j);
	            if (goles > 0) { 
	                tabla.add(j.getNombre() + " " + j.getApellido() + " - " + goles + " goles");
	            }
	        }
	    }

	    
	    tabla.sort((g1, g2) -> {
	        int goles1 = Integer.parseInt(g1.split(" - ")[1].replace(" goles", ""));
	        int goles2 = Integer.parseInt(g2.split(" - ")[1].replace(" goles", ""));
	        return Integer.compare(goles2, goles1);
	    });

	    return tabla;
	}
	
	
	public List<String> generarTablaAsistidores() {
	    List<String> tabla = new ArrayList<>();

	    for (Equipo e : equipos) {
	        for (Jugador j : e.getJugadores()) {
	            int asistencias = calcularAsistenciasJugador(j);
	            if (asistencias > 0) { 
	                tabla.add(j.getNombre() + " " + j.getApellido() + " - " + asistencias + " asistencias");
	            }
	        }
	    }

	    
	    tabla.sort((a1, a2) -> {
	        int asis1 = Integer.parseInt(a1.split(" - ")[1].replace(" asistencias", ""));
	        int asis2 = Integer.parseInt(a2.split(" - ")[1].replace(" asistencias", ""));
	        return Integer.compare(asis2, asis1);
	    });

	    return tabla;
	}



	
	@Override
	public String toString() {
		return "Torneo [nombreTorneo=" + nombreTorneo + ", temporada=" + temporada + ", equipos=" + equipos
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idTorneo=" + idTorneo + "]";
	}
	
	

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}

	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
