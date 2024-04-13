package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import lombok.Data;

@Data
public class TransaccionRequest {
    private Long idCliente;
    private Long idProducto;
    private TipoTransaction tipoTransaccion;
    private Double monto;
    private int numeroCuentaDestinoTransferencia;
}
