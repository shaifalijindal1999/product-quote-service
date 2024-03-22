package com.productquoteservice.repositories;

import com.productquoteservice.schema.CustomerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Component
public interface CustomerDataRepository extends CrudRepository<CustomerData, String> {
 // String is type of ID
}

