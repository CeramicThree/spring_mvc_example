package com.ceramicthree.web.services;

import com.ceramicthree.web.models.Account;
import com.ceramicthree.web.models.CustomUserDetails;
import com.ceramicthree.web.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Account> account = accountRepo.findByEmail(s);

        account.orElseThrow(() -> new UsernameNotFoundException("User with email:" + s + ",does not exist."));

        return account.map(CustomUserDetails::new).get();
    }
}
