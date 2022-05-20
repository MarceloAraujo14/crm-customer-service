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
    private String name;
    private String motherName;
    private String documentType;
    private String documentContent;
    private String contactType;
    private String contactContent;
    private String addressStreet;
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
