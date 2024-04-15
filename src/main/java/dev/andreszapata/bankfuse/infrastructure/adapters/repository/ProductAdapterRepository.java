package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ProductEntity;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper.ProductMapper;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.ProductRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapterRepository implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;

    @Override
    public void registrarProducto(Product producto) {

        productRepositoryJpa.save(ProductMapper.INSTANCE.domainToEntity(producto));

    }

    @Override
    public void actualizarProducto(Product producto) {
        productRepositoryJpa.save(ProductMapper.INSTANCE.domainToEntity(producto));

    }

    @Override
    public void eliminarProducto(Long idProducto) {
        productRepositoryJpa.deleteById(idProducto);

    }

    @Override
    public Product obtenerProductoPorId(Long idProducto) {

        return ProductMapper.INSTANCE.entityToDomain(productRepositoryJpa.findById(idProducto)
                .orElseThrow(() -> new CustomException("No se encontro el producto")));
    }

    @Override
    public boolean existeProducto(Long idProducto) {
       return productRepositoryJpa.existsById(idProducto);
    }

    @Override
    public boolean existeProductoActivoByClientId(Long idClient) {
        return productRepositoryJpa.existsByIdProductAndEstadoCuenta(idClient, EstadoCuenta.ACTIVA);
    }

    @Override
    public void actualizarSaldoProducto(Long idProduct, Double nuevoSaldo) {

        ProductEntity product = productRepositoryJpa.findById(idProduct)
                .orElseThrow(() -> new CustomException("No se encontro el producto"));

        product.setSaldo(nuevoSaldo);

        productRepositoryJpa.save(product);

    }

    @Override
    public Double obtenerSaldoProducto(Long idProduct) {
        ProductEntity product = productRepositoryJpa.findById(idProduct)
                .orElseThrow(() -> new CustomException("No se encontro el producto"));

        return product.getSaldo();
    }

    @Override
    public void agregarSaldoProducto(Double monto, int numeroCuentaDestinoTransferencia) {

        ProductEntity product = productRepositoryJpa.findByNumeroCuenta(numeroCuentaDestinoTransferencia)
                .orElseThrow(() -> new CustomException("No se encontro el producto"));

        product.setSaldo(product.getSaldo() + monto);

        try {
            productRepositoryJpa.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("No se pudo agregar saldo al producto",e);
        }

    }
}
