package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;

public class Product {

    private Long idProduct;
    private TipoCuenta tipoCuenta;
    private int numeroCuenta;
    private EstadoCuenta estadoCuenta;
    private Double saldo;
    private Boolean excentaGmf;
    private Client client;

    public Product(Long idProduct, TipoCuenta tipoCuenta, int numeroCuenta, EstadoCuenta estadoCuenta, Double saldo, Boolean excentaGmf, Client client) {
        this.idProduct = idProduct;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
        this.excentaGmf = excentaGmf;
        this.client = client;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getExcentaGmf() {
        return excentaGmf;
    }

    public void setExcentaGmf(Boolean excentaGmf) {
        this.excentaGmf = excentaGmf;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
