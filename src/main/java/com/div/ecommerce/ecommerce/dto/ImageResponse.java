package com.div.ecommerce.ecommerce.dto;

public class ImageResponse {
    private Long id;
    private String name;
    private String extension;
    private String image;

    public ImageResponse(Long id, String name, String extension, String image) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.image = image;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
