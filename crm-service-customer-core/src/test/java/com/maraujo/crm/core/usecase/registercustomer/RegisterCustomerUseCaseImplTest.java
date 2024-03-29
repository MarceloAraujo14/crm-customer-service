package com.maraujo.crm.core.usecase.registercustomer;

import com.maraujo.crm.core.usecase.exception.DocumentAlreadyRegisteredException;
import com.maraujo.crm.core.domain.Customer;
import com.maraujo.crm.core.domain.vo.Address;
import com.maraujo.crm.core.domain.vo.Contact;
import com.maraujo.crm.core.domain.vo.Document;
import com.maraujo.crm.core.domain.vo.PersonName;
import com.maraujo.crm.core.external.CustomerOutput;
import com.maraujo.crm.core.repository.CustomerTestRepository;
import com.maraujo.crm.core.util.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterCustomerUseCaseImplTest {

    @Mock
    private CustomerTestRepository repository;
    @Mock
    private CustomerMapper mapper;
    @InjectMocks
    private RegisterCustomerUseCaseImpl underTest;

    private RegisterCustomerInput customerInputTest;
    private CustomerOutput customerOutputTest;
    private Customer customerTest;

    @BeforeEach
    void setUp() {
        customerTest = new Customer(
                new PersonName("Jhon Doe"),
                new PersonName("Gina Doe"),
                new Document("01234567890"),
                new Contact("(21) 98558-9999"),
                new Address("Street A", "25A"));
        customerInputTest = new RegisterCustomerInput(
                "Jhon Doe",
                "Gina Doe",
                "01234567890",
                "(21) 98558-9999",
                "Street A",
                "25A"
        );
        customerOutputTest = new CustomerOutput(
                "Jhon Doe",
                "Gina Doe",
                "CPF",
                "01234567890",
                "PHONE",
                "21985589999",
                "Street A",
                "25A"
        );
    }
    @Test
    void registerNewCustomer() {
        //given
        //when
        lenient().when(mapper.toCustomer(customerInputTest)).thenReturn(customerTest);
        lenient().when(repository.save(customerTest)).thenReturn(customerTest);
        lenient().when(mapper.toOutput(customerTest)).thenReturn(customerOutputTest);
        CustomerOutput result = underTest.registerNewCustomer(customerInputTest);
        //then
        assertThat(result).isEqualTo(customerOutputTest);
    }
    @Test
    void ShouldThrowWhenCustomerWithSameDocumentAlreadyRegistered(){
        //given
        String documentContent = "01234567890";
        //when
        when(repository.existsByDocument(documentContent)).thenReturn(true);
        //then
        assertThatThrownBy(() -> underTest.registerNewCustomer(customerInputTest)).isInstanceOf(DocumentAlreadyRegisteredException.class)
                .hasMessageContaining("Customer with the document " + documentContent + " already registered.");
        verify(repository, times(1)).existsByDocument(documentContent);
    }
}