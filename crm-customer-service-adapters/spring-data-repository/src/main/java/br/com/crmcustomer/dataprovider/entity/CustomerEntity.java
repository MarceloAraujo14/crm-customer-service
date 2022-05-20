package br.com.crmcustomer.dataprovider.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "customer")
@Table(name = "tb_customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "mother_name", nullable = false, length = 50)
    private String motherName;
    @Column(name = "doc_type", nullable = false, length = 10)
    private String documentType;
    @Column(name = "doc_content", nullable = false, length = 14)
    private String documentContent;
    @Column(name = "contact_type", nullable = false, length = 10)
    private String contactType;
    @Column(name = "contact_content", nullable = false, length = 50)
    private String contactContent;
    @Column(name = "address_street", nullable = false, length = 50)
    private String addressStreet;
    @Column(name = "address_number", nullable = false, length = 50)
    private String addressNumber;

    public CustomerEntity(String name,
                          String motherName,
                          String documentType,
                          String documentContent,
                          String contactType,
                          String contactContent,
                          String addressStreet,
                          String addressNumber) {
        this.name = name;
        this.motherName = motherName;
        this.documentType = documentType;
        this.documentContent = documentContent;
        this.contactType = contactType;
        this.contactContent = contactContent;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
