package northwind.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecureFileUpload {
	
	private static String UPLOAD_LOCATION = "/Users/larryricker/Documents/SecureCodingInJava/upload/";
	
	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("index");
	}

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		/*
		 * Do not allow empty files
		 */
		if (file.isEmpty()) {
			return new ModelAndView("result", "message", "Please select a file and try again");
		}
		/*
		 * Only allow pdf files (whitelist)
		 */
		if (!"application/pdf".equalsIgnoreCase(file.getContentType())) {
			return new ModelAndView("result", "message", "Please select a pdf file, your file was of type " + file.getContentType());
		}
		/*
		 * Do not allow files above size limit
		 */
		if (file.getSize() > 1048575) {
			return new ModelAndView("result", "message", "Your file " + file.getOriginalFilename()  + " has not been uploaded successfully.  The file must be less than 10 MB size.");
		}
		
		try {
			// read and write the file to the selected location
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_LOCATION + file.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			 e.printStackTrace();
		}
		
		return new ModelAndView("result", "message", "File uploaded successfully");
	}
	
}
