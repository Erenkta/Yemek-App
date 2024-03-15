package com.proje.yemekapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import java.util.List;
import java.util.Optional;


@Repository
public interface KurumRepository extends JpaRepository<KurumEntity,Long> {

    Optional<KurumEntity> findByKurumAdi(String kurumAdi);
    Optional<List<KurumEntity>> findByKurumIl(String kurumIl);
    
}
