
package strategy;

import core.ImpuestoStrategy;

public class ExoneradoStrategy implements ImpuestoStrategy {
    @Override
    public double calcular(double subtotal) {
        return 0.0; 
    }
}
