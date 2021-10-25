package com.pxp.springbootmongodbmysql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pxp.springbootmongodbmysql.document.CreditCardDocument;

@Repository
public interface CreditCardDocumentRepository extends MongoRepository<CreditCardDocument, String>{

}
