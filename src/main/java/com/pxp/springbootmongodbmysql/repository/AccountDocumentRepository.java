package com.pxp.springbootmongodbmysql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pxp.springbootmongodbmysql.document.AccountDocument;
import com.pxp.springbootmongodbmysql.document.CustomerDocument;

@Repository
public interface AccountDocumentRepository extends MongoRepository<AccountDocument, String> {

}
