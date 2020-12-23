package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    //Display all regions in Canada
    List<Region> findByCountry(String Country);
    List<Region> findRegionsByCountry(String country);
    List<Region> findAllByCountry(String Country);

    //Display all regions in Canada, without duplication
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findAllByCountryContains(String str);
    List<Region> findByCountryContaining(String country);

    //Display all regions with country name includes 'United' in order
    List<Region> findAllByCountryContainsOrderByRegion(String country);
    List<Region> findAllByCountryContainsOrderByCountry(String country);


}
