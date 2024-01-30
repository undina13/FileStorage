package ru.undina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.undina.entity.AppDocument;

public interface AppDocumentDAO extends JpaRepository<AppDocument, Long> {
}
