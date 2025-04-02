package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
import com.example.MyMenu.repository.RestaurantsImageRepository;
import com.example.MyMenu.service.RestaurantsImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantsImageServiceImpl implements RestaurantsImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final RestaurantsImageRepository restaurantsImageRepository;

    @Autowired
    public RestaurantsImageServiceImpl(RestaurantsImageRepository restaurantsImageRepository) {
        this.restaurantsImageRepository = restaurantsImageRepository;
    }

    @Override
    public void deleteById(Long id) throws NoEntityByIdException {
        if(restaurantsImageRepository.existsById(id)){
            restaurantsImageRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public RestaurantsImage save(RestaurantsImage entity) throws IOException {
        return restaurantsImageRepository.save(entity);
    }

    @Override
    public Optional<RestaurantsImage> getById(Long id) throws NoEntityByIdException {
        Optional<RestaurantsImage> image = restaurantsImageRepository.findById(id);

        if(image.isEmpty()){
            throw new NoEntityByIdException(id);
        }

        return image;
    }

    @Override
    public List<RestaurantsImage> getAll() throws EmptyListException, MalformedURLException {
        List<RestaurantsImage> list = restaurantsImageRepository.findAll();
        RestaurantsImage image = new RestaurantsImage();


        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }

    public String saveImage(MultipartFile file) throws IOException{
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    public Resource getImageUrl(String filename) throws MalformedURLException {

            Path filePath = Paths.get(uploadDir).resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + filename);
            }

    }
}
