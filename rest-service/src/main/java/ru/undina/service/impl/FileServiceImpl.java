package ru.undina.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import ru.undina.dao.AppDocumentDAO;
import ru.undina.dao.AppPhotoDAO;
import ru.undina.entity.AppDocument;
import ru.undina.entity.AppPhoto;
import ru.undina.entity.BinaryContent;
import ru.undina.service.FileService;

import java.io.File;
import java.io.IOException;

@Log4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final AppDocumentDAO appDocumentDAO;
    private final AppPhotoDAO appPhotoDAO;


    @Override
    public AppDocument getDocument(String docId) {
        //TODO добавить дешифрование хеш-строки
        Long id = Long.parseLong(docId);
        return appDocumentDAO.findById(id).orElse(null);
    }

    @Override
    public AppPhoto getPhoto(String photoId) {
        //TODO добавить дешифрование хеш-строки
        Long id = Long.parseLong(photoId);
        return appPhotoDAO.findById(id).orElse(null);
    }

    @Override
    public FileSystemResource getFileSystemResource(BinaryContent binaryContent) {
        try {
            //TODO добавить генерацию имени временного файла
            File temp = File.createTempFile("tempFile", ".bin");
            temp.deleteOnExit();
            FileUtils.writeByteArrayToFile(temp, binaryContent.getFileAsArrayOfBytes());
            return new FileSystemResource(temp);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }
}
