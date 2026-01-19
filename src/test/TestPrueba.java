package test;

import java.time.LocalDate;
import java.util.ArrayList;

import modelos.Entrenador;
import modelos.Equipo;
import modelos.EstadisticaJugador;
import modelos.Jugador;
import modelos.Partido;
import modelos.Torneo;

public class TestPrueba {

	public static void main(String[] args) {
		// Crear jugadores
		Jugador messi = new Jugador("Lionel", "Messi", 22222222L,
		        LocalDate.of(1987, 6, 24), 1.70f, 72f, "DEL", 10);

		Jugador mbappe = new Jugador("Kylian", "Mbappé", 33333333L,
		        LocalDate.of(1998, 12, 20), 1.78f, 73f, "DEL", 7);

		// Crear equipos
		Entrenador pep = new Entrenador("Pep", "Guardiola", 12345678L,
		        LocalDate.of(1971, 1, 18), "Posesión alta");

		Entrenador luis = new Entrenador("Luis", "Enrique", 87654321L,
		        LocalDate.of(1970, 5, 8), "Presión alta");

		Equipo barcelona = new Equipo("Barcelona", "BAR", LocalDate.of(1899, 11, 29), new ArrayList<>(), pep);
		Equipo psg = new Equipo("PSG", "PSG", LocalDate.of(1970, 8, 12), new ArrayList<>(), luis);

		barcelona.agregarJugador(messi);
		psg.agregarJugador(mbappe);

		// Crear partido
		Partido partido1 = new Partido(LocalDate.of(2023, 3, 1), "Camp Nou", barcelona, psg, 1);

		// Crear estadísticas
		EstadisticaJugador est1 = new EstadisticaJugador(messi, partido1, 2, 1, 90); // Messi hizo 2 goles
		EstadisticaJugador est2 = new EstadisticaJugador(mbappe, partido1, 1, 0, 90); // Mbappé hizo 1 gol

		partido1.agregarEstadistica(est1);
		partido1.agregarEstadistica(est2);

		// Crear torneo y agregar partido
		Torneo champions = new Torneo("Champions League", "Primavera",
		        new ArrayList<>(),      
		        new ArrayList<>(),      
		        LocalDate.of(2023, 3, 1),
		        LocalDate.of(2023, 6, 30),
		        1);


		champions.agregarEquipo(barcelona);
		champions.agregarEquipo(psg);
		champions.agregarPartido(partido1);

		
		System.out.println(champions.traerGanadoresPorFecha(LocalDate.of(2023, 3, 1)));
		System.out.println("Puntos Barcelona: " + champions.calcularPuntosEquipo(barcelona));
		System.out.println("Puntos PSG: " + champions.calcularPuntosEquipo(psg));
		System.out.println("Tabla de posiciones:");
		for (String fila : champions.generarTablaPosiciones()) {
		    System.out.println(fila);
		
		}
		System.out.println("Goles de Messi en el torneo: " + champions.calcularGolesJugador(messi));
		System.out.println("Goles de Mbappé en el torneo: " + champions.calcularGolesJugador(mbappe));
		System.out.println("Asistencias de Messi en el torneo: " + champions.calcularAsistenciasJugador(messi));
		System.out.println("Asistencias de Mbappé en el torneo: " + champions.calcularAsistenciasJugador(mbappe));
		System.out.println("Tabla de goleadores:");
		for (String fila : champions.generarTablaGoleadores()) {
		    System.out.println(fila);
		}
		System.out.println("Tabla de asistidores:");
		for (String fila : champions.generarTablaAsistidores()) {
		    System.out.println(fila);
		}

	}

}
