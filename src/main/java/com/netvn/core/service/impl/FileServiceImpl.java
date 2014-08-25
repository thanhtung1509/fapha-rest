package com.netvn.core.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.netvn.core.entity.Image;
import com.netvn.core.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
private static final Random RANDOM = new Random();
	
	private @Value("${serverUrl}") String serverUrl;
	
	@Autowired
	private ServletContext context;

	@Override
	public String getPath(Image image) {
		if (!image.getPath().startsWith(serverUrl)) {
			return serverUrl + image.getPath();
		}
		return image.getPath();
	}

	@Override
	public Image store(MultipartFile mFile) {

		try {
			return this.store(mFile.getOriginalFilename(),
					mFile.getContentType(), mFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(Image image) {
		String path = context.getRealPath("/");
		File file = new File(path + image.getPath());
		if (file.isFile() && file.exists()) {
			return file.delete();
		}
		return false;
	}

	@Override
	public boolean delete(Image[] images) {
		return false;
	}

	public String getPath(String path) {
		return path;
	}

	@Override
	public Image store(String filename, String contentType,
			InputStream inputStream) {
		String path = context.getRealPath("/");
		String destination = path + "images";
		File dir = new File(destination);
		// create folder to store images
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		File file = null;
		try {
			file = new File(destination + "/" + System.currentTimeMillis()
					+ RANDOM.nextInt() + "." + FilenameUtils.getExtension(filename));
			FileOutputStream fos = new FileOutputStream(file);
			copyStream(inputStream, fos);
			Image image = new Image();
			image.setPath("images/" + file.getName());
			return image;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void copyStream(InputStream input, OutputStream output)
			throws IOException {
		byte[] buffer = new byte[1024]; // Adjust if you want
		int bytesRead;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
	}
}
