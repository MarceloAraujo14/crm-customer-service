package com.maraujo.crm.core.usecase.clearcache;

import com.maraujo.crm.core.port.CustomerRepository;

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
