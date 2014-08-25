package com.netvn.core.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.netvn.core.entity.Image;

public interface FileService {
	/**
	 * store the image in the folder or haystack...
	 * It not save the entity to database.
	 * @param mFile file to store
	 * @return the created file
	 */
	Image store(MultipartFile mFile);
	
	Image store(String filename, String contentType, InputStream inputStream);
	
	/**
	 * delete the file in folder or haystack...
	 * It not delete the entity in database.
	 * @param image the File to delete
	 * @return
	 */
	boolean delete(Image image);
	
	boolean delete(Image[] images);
	
	/**
	 * Get the path of file.
	 * @param image
	 * @return
	 */
	String getPath(Image image);

	String getPath(String path);
}
