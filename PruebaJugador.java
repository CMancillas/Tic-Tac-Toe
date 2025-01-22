public class PruebaJugador 
{
    public static void main( String args[] )
    {
        JugadorHumano jugador1 = new JugadorHumano( "Polly", 'x');
        JugadorComputadora jugador2 = new JugadorComputadora('o');

        System.out.println( "Cual es tu movimiento? ");
        int[] movimientoJugador1 = jugador1.obtenerMovimiento();
        
        System.out.printf( "Movimiento de: %s, Fila: %d Columna: %d \n",
            jugador1.obtenerNombre(), movimientoJugador1[0], movimientoJugador1[1]);

        int[] movimientoJugador2 = jugador2.obtenerMovimiento();

        System.out.printf( "Movimiento de CPU, Fila: %d Columna: %d \n",
             movimientoJugador2[0], movimientoJugador2[1]);
    }    
}
