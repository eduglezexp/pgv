package com.docencia.aed.repository;

import com.docencia.aed.entity.Publisher;

import java.util.List;

/**
 * Repositorio de editoriales (sin BBDD).
 */
public interface PublisherRepository {

    List<Publisher> findAll();

    Publisher save(Publisher publisher);
}
