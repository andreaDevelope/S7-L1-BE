package it.epicode.S5_L5_BE.web.controllers;

import it.epicode.S5_L5_BE.db.pojo.Avatar;
import it.epicode.S5_L5_BE.db.serv.AvatarServ;
import it.epicode.S5_L5_BE.db.serv.CloudinaryServ;
import it.epicode.S5_L5_BE.web.dto.AvatarUploadRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/avatars")
public class AvatarController {

    @Autowired
    private CloudinaryServ cloudinaryService;

    @Autowired
    private AvatarServ avatarServ;

    @PostMapping(path = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<Map> uploadFile(@Valid @ModelAttribute AvatarUploadRequest request) {
        if (request.getFile().isEmpty()) {
            throw new IllegalArgumentException("Il file non può essere vuoto");
        }

        String folder = "avatars";
        Map result = cloudinaryService.uploader(request.getFile(), folder);
        String imageUrl = (String) result.get("url");

        Avatar avatar = new Avatar();
        avatar.setImageUrl(imageUrl);
        avatarServ.save(avatar, request.getDipendenteId());

        return ResponseEntity.ok(result);
    }

}
