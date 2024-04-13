package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.ProductRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapterRepository implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;

    @Override
    public void registrarProducto(Product producto) {

    }

    @Override
    public void actualizarProducto(Product producto) {

    }

    @Override
    public void eliminarProducto(Long idProducto) {

    }

    @Override
    public Product obtenerProductoPorId(Long idProducto) {
        return null;
    }

    @Override
    public boolean existeProducto(Long idProducto) {
        return false;
    }

    @Override
    public boolean existeProductoActivoByClientId(Long idClient) {
        return false;
    }

    @Override
    public void actualizarSaldoProducto(Long idProduct, Double nuevoSaldo) {

    }

    @Override
    public Double obtenerSaldoProducto(Long idProduct) {
        return 0.0;
    }
}
