package com.miu.edu.CS590.account.repository;

import com.miu.edu.CS590.account.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Integer> {
    UserAccount findAccountByAccountId(Integer accountId);
}
