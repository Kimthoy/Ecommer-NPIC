package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProfileDTO {
    private Long id;
    private String profileName;
    private String profileImage;
    private String email;
    private String phoneNumber;
    private String address;
    private User user;
}
