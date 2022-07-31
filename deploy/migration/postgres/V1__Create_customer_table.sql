create TABLE tb_customer (
  doc_content VARCHAR(14) NOT NULL,
   name VARCHAR(50) NOT NULL,
   mother_name VARCHAR(50) NOT NULL,
   doc_type VARCHAR(10) NOT NULL,
   contact_type VARCHAR(10) NOT NULL,
   contact_content VARCHAR(50) NOT NULL,
   address_street VARCHAR(50) NOT NULL,
   address_number VARCHAR(50) NOT NULL,
   CONSTRAINT pk_tb_customer PRIMARY KEY (doc_content)
);

alter table tb_customer add CONSTRAINT uc_tb_customer_doc_content UNIQUE (doc_content);