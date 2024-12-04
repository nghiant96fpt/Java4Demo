package com.fpoly.java4.services;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadFileService {
    private static final String UPLOAD_DIR = "images";

    public static String uploadFile(HttpServletRequest req, Part image) {
	try {
	    String applicationPath = req.getServletContext().getRealPath("");
	    String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
		uploadDir.mkdir();
	    }

	    Thread.sleep(20);

	    Date date = new Date();
	    String fileNameSubmit = date.getTime() + ".jpg";
	    String fileName = Paths.get(fileNameSubmit).getFileName().toString();

	    // Save file to the directory
	    image.write(uploadPath + File.separator + fileName);

	    return fileName;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
