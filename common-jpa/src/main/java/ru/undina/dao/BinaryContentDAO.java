package ru.undina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.undina.entity.BinaryContent;

public interface BinaryContentDAO extends JpaRepository<BinaryContent, Long> {
}
