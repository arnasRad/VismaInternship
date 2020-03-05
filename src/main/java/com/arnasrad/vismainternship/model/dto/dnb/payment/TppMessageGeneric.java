package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.arnasrad.vismainternship.model.enums.TppMessageCategory;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TppMessageGeneric {
    @NotNull
    private TppMessageCategory category;
    @NotNull
    private String code;
    private String path;
    private String text;

    public TppMessageCategory getCategory() {
        return category;
    }

    public void setCategory(TppMessageCategory category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
