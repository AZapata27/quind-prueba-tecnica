package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;

public class Transaction {

    private Long idTransaccion;
    private Long idClient;
    private Long idProduct;
    private TipoTransaction tipoTransaction;

    public Transaction(Long idTransaccion, Long idClient, Long idProduct, TipoTransaction tipoTransaction) {
        this.idTransaccion = idTransaccion;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.tipoTransaction = tipoTransaction;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public TipoTransaction getTipoTransaction() {
        return tipoTransaction;
    }

    public void setTipoTransaction(TipoTransaction tipoTransaction) {
        this.tipoTransaction = tipoTransaction;
    }

}
