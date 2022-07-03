package com.pro.manga.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

	void delete(String storedFilename) throws IOException;

	Path load(String filename);

	Resource loadsResource(String filename);

	void store(MultipartFile file, String storedFileName);

	String getStoredString(MultipartFile file, String id);



}
