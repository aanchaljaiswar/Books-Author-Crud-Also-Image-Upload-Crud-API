package com.devtool.test.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// Static way to upload image
	// private final String
	// UPLOAD_DIR="C:\\AJ\\D_mvccrud\\bootdevtool\\src\\main\\resources\\static\\images";

	// Dynamic way to upload image
	private final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

	// Default constructor of FileUploadHelper
	public FileUploadHelper() throws IOException {} 

	public boolean uploadFile(MultipartFile mtf) {
		boolean f = false;
		try {
//			//read
//			InputStream is = mtf.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//		
//			//write
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+ mtf.getOriginalFilename()) ;
//			fos.write(data);
//			fos.flush();
//			fos.close();
//			f=true;

// 2 ways--------> File.copy(in,target,options;)

			Files.copy(mtf.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + mtf.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
