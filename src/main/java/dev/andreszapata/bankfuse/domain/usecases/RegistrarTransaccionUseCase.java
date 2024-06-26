package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.repository.TransaccionRepository;

import java.time.LocalDateTime;

public class RegistrarTransaccionUseCase {

    private final TransaccionRepository transaccionRepository;
    private final ProductRepository productRepository;

    public RegistrarTransaccionUseCase(TransaccionRepository transaccionRepository, ProductRepository productRepository) {
        this.transaccionRepository = transaccionRepository;
        this.productRepository = productRepository;
    }

    public void ejecutar(Transaction transaccion) {

        if (transaccion.getMonto() <= 0) {
            throw new CustomException("El monto de la transacción debe ser mayor que cero");
        }

        Double saldoActual = productRepository.obtenerSaldoProducto(transaccion.getIdProducto());

        if (transaccion.getTipoTransaccion() == TipoTransaction.RETIRO && transaccion.getMonto() > saldoActual) {
            throw new CustomException("Saldo insuficiente para realizar el retiro");
        }

        transaccion.setFechaTransaccion(LocalDateTime.now());

        Double nuevoSaldo = actualizarSaldo(transaccion , saldoActual );
        productRepository.actualizarSaldoProducto(transaccion.getIdProducto(), nuevoSaldo);

        transaccionRepository.registrarTransaccion(transaccion);
    }

    protected Double actualizarSaldo(Transaction transaccion, Double saldoActual) {
        return switch (transaccion.getTipoTransaccion()) {
            case CONSIGNACION -> saldoActual +  transaccion.getMonto();
            case RETIRO -> saldoActual -  transaccion.getMonto();
            case TRANSFERENCIA -> {
                realizarTransferecncia(transaccion);
                yield saldoActual -  transaccion.getMonto();
            }
        };
    }

    protected void realizarTransferecncia(Transaction transaccion) {

        try {

            productRepository.agregarSaldoProducto(transaccion.getMonto(), transaccion.getNumeroCuentaDestinoTransferencia());

        } catch (Exception e){
            throw new CustomException(e.getMessage(), e);
        }

    }
}
