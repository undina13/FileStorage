package ru.undina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.undina.entity.RawData;

public interface RawDataDAO extends JpaRepository<RawData, Long> {
}
