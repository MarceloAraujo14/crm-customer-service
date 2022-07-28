package br.com.crmcustomer.core.usecase.clearcache;

import br.com.crmcustomer.core.port.CustomerRepository;

import javax.inject.Named;

@Named
public class ClearCacheUseCaseImpl implements ClearCacheUseCase {

    private final CustomerRepository customerRepository;

    public ClearCacheUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void clearCache(){
        customerRepository.clearCache();
    }

}
