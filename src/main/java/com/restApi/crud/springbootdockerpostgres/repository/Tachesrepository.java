package com.restApi.crud.springbootdockerpostgres.repository;

import com.restApi.crud.springbootdockerpostgres.entity.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tachesrepository extends JpaRepository<Taches,Integer> {
}
