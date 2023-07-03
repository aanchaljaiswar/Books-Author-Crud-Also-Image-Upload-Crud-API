package com.devtool.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devtool.test.helper.FileUploadHelper;

@RestController
public class FileUploadContoller {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

//		System.out.println("Original_File_Name - " + file.getOriginalFilename() + "\n " + 
//							"Size_Of_Image - " + file.getSize() + "\n " + 
//							"Content_Type_Of_Image - " + file.getContentType() + "\n " + 
//							"Uploading_File_Name - " + file.getName());

		try {
			// Validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}

			// Validation
//			if(!file.getContentType().equalsIgnoreCase("img/jpeg"))
//			{
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Content Should be Img/Jpeg");
//			}
//			
			String fileName = file.getOriginalFilename();
			String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

			if (!fileExtension.equalsIgnoreCase("jpg") && !fileExtension.equalsIgnoreCase("jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Content only JPG format");
			}

			// File Upload Code Static
//			boolean f = fileUploadHelper.uploadFile(file);
//			if (f) {
//				return ResponseEntity.ok("File successfully uploaded");
//
//			}

			// File Upload Code Dynamic
//			boolean f = fileUploadHelper.uploadFile(file);
//			if (f) {
//				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toString());
//
//			}
			
			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
			    String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			        .path("/images/")
			        .path(file.getOriginalFilename())
			        .toUriString();

			    return ResponseEntity.ok(fileUri);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ...Try again");
	}
}
