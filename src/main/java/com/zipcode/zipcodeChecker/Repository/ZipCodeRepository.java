package com.zipcode.zipcodeChecker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zipcode.zipcodeChecker.entity.ZipCodes;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCodes, Long>{

}
