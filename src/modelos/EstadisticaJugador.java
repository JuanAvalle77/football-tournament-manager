package modelos;

public class EstadisticaJugador {
	
	private Jugador jugador;   
    private Partido partido;
    private int cantGoles;
    private int cantAsistencias;
    private int cantMinutos;

    public EstadisticaJugador(Jugador jugador, Partido partido, int cantGoles, int cantAsistencias, int cantMinutos) {
        this.jugador = jugador;
        this.partido = partido;
        this.cantGoles = cantGoles;
        this.cantAsistencias = cantAsistencias;
        this.cantMinutos = cantMinutos;
    }

    @Override
    public String toString() {
        return "EstadisticaJugador [jugador=" + jugador.getNombre() + " " + jugador.getApellido() +
               ", partido=" + partido.getIdPartido() + 
               ", cantGoles=" + cantGoles + 
               ", cantAsistencias=" + cantAsistencias + 
               ", cantMinutos=" + cantMinutos + "]";
    }

    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    public int getCantAsistencias() {
        return cantAsistencias;
    }

    public void setCantAsistencias(int cantAsistencias) {
        this.cantAsistencias = cantAsistencias;
    }

    public int getCantMinutos() {
        return cantMinutos;
    }

    public void setCantMinutos(int cantMinutos) {
        this.cantMinutos = cantMinutos;
    }
}
