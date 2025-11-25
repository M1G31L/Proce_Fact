
package core;

import models.Pedido;
import models.Factura;

public interface FacturaService {
    Factura generarFactura(Pedido pedido);
}
    

