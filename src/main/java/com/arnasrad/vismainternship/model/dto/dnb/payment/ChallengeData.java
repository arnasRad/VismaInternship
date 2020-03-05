package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChallengeData {

    private String additionalInformation;
    private String data;
    private String image;
    private String imageLink;
    private String otpFormat;
    private String otpMaxLength;

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getOtpFormat() {
        return otpFormat;
    }

    public void setOtpFormat(String otpFormat) {
        this.otpFormat = otpFormat;
    }

    public String getOtpMaxLength() {
        return otpMaxLength;
    }

    public void setOtpMaxLength(String otpMaxLength) {
        this.otpMaxLength = otpMaxLength;
    }
}
