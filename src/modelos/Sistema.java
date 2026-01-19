package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Jugador> jugadores;
    private List<Entrenador> entrenadores;
    private List<Equipo> equipos;
    private List<Torneo> torneos;
    private List<Partido> partidos;
    
    public Sistema() {
        this.jugadores = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
        this.equipos = new ArrayList<Equipo>();
        this.torneos = new ArrayList<Torneo>();
        this.partidos = new ArrayList<Partido>();
    }
    
    public boolean agregarJugador(Jugador jugador) {
        if (jugador != null && !jugadores.contains(jugador)) {
            return jugadores.add(jugador);
        }
        return false;
    }

    public boolean agregarEntrenador(Entrenador entrenador) {
        if (entrenador != null && !entrenadores.contains(entrenador)) {
            return entrenadores.add(entrenador);
        }
        return false;
    }

    public boolean agregarEquipo(Equipo equipo) {
        if (equipo != null && !equipos.contains(equipo)) {
            return equipos.add(equipo);
        }
        return false;
    }

    public boolean agregarTorneo(Torneo torneo) {
        if (torneo != null && !torneos.contains(torneo)) {
            return torneos.add(torneo);
        }
        return false;
    }

    public boolean agregarPartido(Partido partido) {
        if (partido != null && !partidos.contains(partido)) {
            return partidos.add(partido);
        }
        return false;
    }
    
    public boolean eliminarJugador(Jugador jugador) {
        if (jugador != null) {
            return jugadores.remove(jugador);
        }
        return false;
    }

    public boolean eliminarEntrenador(Entrenador entrenador) {
        if (entrenador != null) {
            return entrenadores.remove(entrenador);
        }
        return false;
    }

    public boolean eliminarEquipo(Equipo equipo) {
        if (equipo != null) {
            return equipos.remove(equipo);
        }
        return false;
    }

    public boolean eliminarTorneo(Torneo torneo) {
        if (torneo != null) {
            return torneos.remove(torneo);
        }
        return false;
    }

    public boolean eliminarPartido(Partido partido) {
        if (partido != null) {
            return partidos.remove(partido);
        }
        return false;
    }
    
 // Traer Jugador por DNI
    public Jugador traerJugador(long dni) {
        for (Jugador j : jugadores) {
            if (j.getDni() == dni) {
                return j;
            }
        }
        return null;
    }

    // Traer Entrenador por DNI
    public Entrenador traerEntrenador(long dni) {
        for (Entrenador e : entrenadores) {
            if (e.getDni() == dni) {
                return e;
            }
        }
        return null;
    }

    // Traer Equipo por código
    public Equipo traerEquipo(String codigo) {
        for (Equipo eq : equipos) {
            if (eq.getCodigo().equalsIgnoreCase(codigo)) {
                return eq;
            }
        }
        return null;
    }

    // Traer Torneo por ID
    public Torneo traerTorneo(int idTorneo) {
        for (Torneo t : torneos) {
            if (t.getIdTorneo() == idTorneo) {
                return t;
            }
        }
        return null;
    }

    // Traer Partido por ID
    public Partido traerPartido(int idPartido) {
        for (Partido p : partidos) {
            if (p.getIdPartido() == idPartido) {
                return p;
            }
        }
        return null;
    }
    
    public List<Entrenador> buscarEntrenadoresPorEstrategia(String estrategia) {
        List<Entrenador> resultado = new ArrayList<>();
        for (Entrenador e : entrenadores) {
            if (e.getEstrategia().equalsIgnoreCase(estrategia)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
    
    public List<Jugador> buscarJugadoresEntreFechas(LocalDate desde, LocalDate hasta) {
        List<Jugador> resultado = new ArrayList<>();
        for (Jugador j : jugadores) {
            if ((j.getFechaNac().isEqual(desde) || j.getFechaNac().isAfter(desde)) &&
                (j.getFechaNac().isEqual(hasta) || j.getFechaNac().isBefore(hasta))) {
                resultado.add(j);
            }
        }
        return resultado;
    }
    
    public List<Equipo> buscarEquiposFundadosAntesDe(LocalDate fecha) {
        List<Equipo> resultado = new ArrayList<>();
        for (Equipo eq : equipos) {
            if (eq.getFechaFundacion().isBefore(fecha)) {
                resultado.add(eq);
            }
        }
        return resultado;
    }
    
    @Override
    public String toString() {
        return "Sistema [jugadores=" + jugadores +
                ", entrenadores=" + entrenadores +
                ", equipos=" + equipos +
                ", torneos=" + torneos +
                ", partidos=" + partidos + "]";
    }

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
