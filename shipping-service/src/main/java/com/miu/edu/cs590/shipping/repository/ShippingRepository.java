package com.miu.edu.cs590.shipping.repository;

import com.miu.edu.cs590.shipping.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}
