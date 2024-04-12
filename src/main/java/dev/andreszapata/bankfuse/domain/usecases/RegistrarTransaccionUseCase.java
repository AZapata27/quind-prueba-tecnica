package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.repository.TransaccionRepository;

public class RegistrarTransaccionUseCase {

    private final TransaccionRepository transaccionRepository;
    private final ProductRepository productRepository;

    public RegistrarTransaccionUseCase(TransaccionRepository transaccionRepository, ProductRepository productRepository) {
        this.transaccionRepository = transaccionRepository;
        this.productRepository = productRepository;
    }

    public void ejecutar(Transaction transaccion) {

        if (transaccion.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto de la transacción debe ser mayor que cero");
        }

        Double saldoActual = productRepository.obtenerSaldoProducto(transaccion.getIdProducto());

        if (transaccion.getTipoTransaction() == TipoTransaction.RETIRO && transaccion.getMonto() > saldoActual) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
        }

        Double nuevoSaldo = actualizarSaldo(transaccion.getTipoTransaction(), saldoActual, transaccion.getMonto());
        productRepository.actualizarSaldoProducto(transaccion.getIdProducto(), nuevoSaldo);

        transaccionRepository.registrarTransaccion(transaccion);
    }

    private Double actualizarSaldo(TipoTransaction tipoTransaction, Double saldoActual, Double monto) {
        switch (tipoTransaction) {
            case CONSIGNACION:
                return saldoActual + monto;
            case RETIRO:
                return saldoActual - monto;
            case TRANSFERENCIA:
                // En una transferencia, el saldo no cambia en la cuenta de envío, ya que se realiza una transacción separada
                return saldoActual;
            default:
                throw new IllegalArgumentException("Tipo de transacción no válido");
        }
    }
}