package com.pxp.springbootmongodbmysql.repository;

import com.pxp.springbootmongodbmysql.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, String> {

    public List<CustomerDocument> findCourseByEmail(String email);

    public void deleteByEmail(String email);
}
