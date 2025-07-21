package com.cognizant.ormlearn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

/**
 * Repository interface for Country entity
 * Extends JpaRepository to provide CRUD operations
 * 
 * @author Cognizant
 * @version 1.0
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     * Find countries by name containing the given string (case insensitive)
     * 
     * @param name the name pattern to search for
     * @return List of countries matching the pattern
     */
    List<Country> findByNameContainingIgnoreCase(String name);

    /**
     * Find country by exact name (case insensitive)
     * 
     * @param name the exact name to search for
     * @return Optional country if found
     */
    Optional<Country> findByNameIgnoreCase(String name);

    /**
     * Custom query to find countries by code pattern
     * 
     * @param codePattern the code pattern to search for
     * @return List of countries matching the code pattern
     */
    @Query("SELECT c FROM Country c WHERE c.code LIKE :codePattern")
    List<Country> findByCodePattern(@Param("codePattern") String codePattern);

    /**
     * Check if a country exists by code
     * 
     * @param code the country code
     * @return true if country exists, false otherwise
     */
    boolean existsByCode(String code);

    /**
     * Count countries by name containing pattern
     * 
     * @param namePattern the name pattern
     * @return count of matching countries
     */
    long countByNameContainingIgnoreCase(String namePattern);
}
