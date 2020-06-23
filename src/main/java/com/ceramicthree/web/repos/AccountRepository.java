package com.ceramicthree.web.repos;

import com.ceramicthree.web.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}