package com.encuentrame.project.encuentrame.services;


import com.encuentrame.project.encuentrame.entities.FileSystem;
import com.encuentrame.project.encuentrame.entities.Image;
import com.encuentrame.project.encuentrame.repositories.FileSystemRepository;
import com.encuentrame.project.encuentrame.repositories.StorageRepository;
import com.encuentrame.project.encuentrame.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository repository;

    @Autowired
    private FileSystemRepository fileSystemRepository;

    private String uploadFolderPath="H:\\STUDYING\\programming\\Proyecto Encuentrame\\c16-53-t-java\\c16-53-t-java\\src\\main\\resources\\static\\img";

    //private String uploadFolderPath=System.getProperty("user.dir")+"/src/main/resources/static/img/";
    public String uploadImage(MultipartFile file) throws IOException {
        Image imageData = repository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }



    public byte[] downloadImage(String fileName) {
        Optional<Image> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws  Exception {
        String filePath=uploadFolderPath+File.separator+file.getOriginalFilename();
//        String filePath=FOLDER_PATH;

        FileSystem fileData=fileSystemRepository.save(FileSystem.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileSystem> fileData = fileSystemRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
