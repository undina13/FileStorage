package ru.undina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.undina.entity.AppPhoto;

public interface AppPhotoDAO extends JpaRepository<AppPhoto, Long> {
}
