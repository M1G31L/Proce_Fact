
package strategy;

import core.ImpuestoStrategy;


public class IGV18Strategy implements ImpuestoStrategy {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.18;
        }
}  
