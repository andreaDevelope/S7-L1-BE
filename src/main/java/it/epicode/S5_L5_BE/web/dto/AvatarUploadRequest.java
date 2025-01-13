package it.epicode.S5_L5_BE.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AvatarUploadRequest {
    @NotNull(message = "Il file è obbligatorio")
    private MultipartFile file;

    @NotNull(message = "Il dipendenteId è obbligatorio")
    private Long dipendenteId;
}
