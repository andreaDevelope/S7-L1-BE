package it.epicode.S5_L5_BE.db.serv;

import com.cloudinary.Cloudinary;
import it.epicode.S5_L5_BE.exceptions.UploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServ {
    @Autowired
    Cloudinary cloudinary;
    public Map uploader(MultipartFile file, String folder)  {
        try {
            Map result =
                    cloudinary
                            .uploader()
                            .upload(file.getBytes(),
                                    Cloudinary.asMap("folder", folder, "public_id", file.getOriginalFilename()));
            return result;
        } catch (IOException e) {
            throw new UploadException("Errore durante l'upload del file " + file.getOriginalFilename());
        }
    }
}
