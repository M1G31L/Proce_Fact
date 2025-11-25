
package models;
import com.tienda.pedidos.Observador;
import java.util.List;
import java.util.ArrayList;

public class Sujeto {
    protected List<Observador> observadores = new ArrayList<>();
    
    public void agregarObservador(Observador obs) {
        observadores.add(obs);
}
    public void notificar(String mensaje) {
        for (Observador obs : observadores) {
            obs.actualizar(mensaje);
        }
    }
}
