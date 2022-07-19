package br.com.crmcustomer.core.usecase.clearcache;

import br.com.crmcustomer.core.port.CustomerRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;

@Named
@AllArgsConstructor
public class ClearCacheUseCaseImpl implements ClearCacheUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public void clearCache(){
        customerRepository.clearCache();
    }

}
