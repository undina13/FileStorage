package ru.undina.service;

import org.springframework.core.io.FileSystemResource;
import ru.undina.entity.AppDocument;
import ru.undina.entity.AppPhoto;
import ru.undina.entity.BinaryContent;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
