package com.maciejmaksymiuk.springbootlibrary.repository;

import com.maciejmaksymiuk.springbootlibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndAndBookId(String userEmail, Long bookId);



}
