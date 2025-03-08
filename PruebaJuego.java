public class PruebaJuego 
{
    public static void main( String[] args )
    {
        Juego nuevoJuego = new Juego();
        JugadorHumano polly = new JugadorHumano("Polly", 'x');

        
        nuevoJuego.rellenarTablero(polly.obtenerCasilla(1), "x");
        nuevoJuego.rellenarTablero(polly.obtenerCasilla(8), "x");
        nuevoJuego.rellenarTablero(polly.obtenerCasilla(5), "o");
        nuevoJuego.rellenarTablero(polly.obtenerCasilla(3), "o");
        nuevoJuego.mostrarTableroInicial();
        nuevoJuego.mostrarTablero();
    }
    
}
