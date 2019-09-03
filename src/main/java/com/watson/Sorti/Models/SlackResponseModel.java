package com.watson.Sorti.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//JSON response model
public class SlackResponseModel {

    @JsonProperty("text")
    private String text;

    @JsonProperty("response_type")
    private String responseType;

    @JsonProperty("attachments")
    public List<Attachment> attachments;

    public SlackResponseModel() {
        attachments = new ArrayList<>();
    }

    public SlackResponseModel(String text) {
        this.text = text;
        attachments = new ArrayList<>();
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
