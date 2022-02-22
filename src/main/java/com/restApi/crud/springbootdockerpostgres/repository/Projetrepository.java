package com.restApi.crud.springbootdockerpostgres.repository;

import com.restApi.crud.springbootdockerpostgres.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Projetrepository extends JpaRepository<Projet,Integer> {


}
