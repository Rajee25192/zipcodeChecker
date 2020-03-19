package com.zipcode.zipcodeChecker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zipcode.zipcodeChecker.entity.ValidateZipCode;

@Repository
public interface ValidatedRepository extends JpaRepository<ValidateZipCode, Long>{

}
