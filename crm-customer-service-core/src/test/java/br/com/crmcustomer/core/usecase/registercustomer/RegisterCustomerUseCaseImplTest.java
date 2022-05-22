package br.com.crmcustomer.core.usecase.registercustomer;

import br.com.crmcustomer.core.domain.Customer;
import br.com.crmcustomer.core.domain.vo.Address;
import br.com.crmcustomer.core.domain.vo.Contact;
import br.com.crmcustomer.core.domain.vo.Document;
import br.com.crmcustomer.core.domain.vo.PersonName;
import br.com.crmcustomer.core.external.CustomerOutput;
import br.com.crmcustomer.core.port.CustomerRepository;
import br.com.crmcustomer.core.repository.CustomerTestRepository;
import br.com.crmcustomer.core.usecase.registercustomer.exception.DocumentAlreadyRegisteredException;
import br.com.crmcustomer.core.util.mapper.CustomerMapper;
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
                "CPF",
                "01234567890",
                "PHONE",
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
        when(repository.getCustomerByDocument(documentContent)).thenReturn(customerTest);
        //then
        verify(repository, times(1)).getCustomerByDocument(documentContent);
        assertThatThrownBy(() -> underTest.registerNewCustomer(customerInputTest)).isInstanceOf(DocumentAlreadyRegisteredException.class)
                .hasMessageContaining("Customer with the document " + documentContent + " already registered.");
    }
}