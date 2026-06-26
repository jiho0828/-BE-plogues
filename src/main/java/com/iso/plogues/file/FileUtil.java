package com.iso.plogues.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iso.plogues.exception.FileUploadException;

@Service
public class FileUtil {

		private final Path fileLocation;
		
		public FileUtil() {
			this.fileLocation = Paths.get("uploads").toAbsolutePath().normalize();
		}
		
		public void store(MultipartFile file) {
			String changeName = getChangeName(file.getOriginalFilename());
			Path targetLocation = this.fileLocation.resolve(changeName);
			try {
				Files.copy(file.getInputStream(),
						   targetLocation);
			} catch (IOException e) {
				e.printStackTrace();
				throw new FileUploadException("파일 저장에 실패했습니다.");
			}
		}
		
	
		
		public String getChangeName(String originName) {
			StringBuilder sb = new StringBuilder();
			sb.append("iso_");
			sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
			sb.append(((int)(Math.random()*900))+100);
			sb.append(originName.substring(originName.lastIndexOf(".")));
			return sb.toString();
		}
	
}
