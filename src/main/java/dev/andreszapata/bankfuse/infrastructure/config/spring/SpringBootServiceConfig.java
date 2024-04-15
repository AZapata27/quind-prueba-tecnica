package dev.andreszapata.bankfuse.infrastructure.config.spring;

import dev.andreszapata.bankfuse.domain.usecases.*;
import dev.andreszapata.bankfuse.infrastructure.adapters.repository.ClientAdapterRepository;
import dev.andreszapata.bankfuse.infrastructure.adapters.repository.ProductAdapterRepository;
import dev.andreszapata.bankfuse.infrastructure.adapters.repository.TransactionAdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringBootServiceConfig {


  @Bean
  public RegistrarClienteUseCase registrarClienteUseCase(ClientAdapterRepository clientAdapterRepository) {
    return new RegistrarClienteUseCase(clientAdapterRepository);
  }

  @Bean
  public ActualizarClienteUseCase actualizarClienteUseCase(ClientAdapterRepository clientAdapterRepository) {

    return new ActualizarClienteUseCase(clientAdapterRepository);
  }

  @Bean
  public EliminarClienteUseCase eliminarClienteUseCase(ClientAdapterRepository clientAdapterRepository) {
    return new EliminarClienteUseCase(clientAdapterRepository);
  }

  @Bean
  public CrearProductoFinancieroUseCase crearProductoFinancieroUseCase(ProductAdapterRepository productAdapterRepository,
                                                                       ClientAdapterRepository clientAdapterRepository) {
    return new CrearProductoFinancieroUseCase(productAdapterRepository,clientAdapterRepository);
  }

  @Bean
  public CambiarEstadoProductoFinancieroUseCase cambiarEstadoProductoFinancieroUseCase(ProductAdapterRepository productAdapterRepository){
    return new CambiarEstadoProductoFinancieroUseCase(productAdapterRepository);
  }

  @Bean
  public RegistrarTransaccionUseCase registrarTransaccionUseCase(TransactionAdapterRepository transactionAdapterRepository,ProductAdapterRepository productAdapterRepository) {
    return  new RegistrarTransaccionUseCase(transactionAdapterRepository,productAdapterRepository);
  }

  @Bean
  public CancelarProductoFinancieroUseCase cancelarProductoFinancieroUseCase(ProductAdapterRepository productAdapterRepository) {
    return new CancelarProductoFinancieroUseCase(productAdapterRepository);
  }

}