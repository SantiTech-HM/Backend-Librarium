package com.Librarium.Demo.Servicios;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryServicio {

    Map upload(MultipartFile multipartFile) throws IOException;

    Map delete(String id) throws IOException;
}
