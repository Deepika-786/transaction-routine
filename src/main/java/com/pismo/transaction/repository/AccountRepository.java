package com.pismo.transaction.repository;

import com.pismo.transaction.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
