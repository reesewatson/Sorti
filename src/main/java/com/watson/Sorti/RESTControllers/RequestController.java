package com.watson.Sorti.RESTControllers;
//Fetch command controller
//Receives a request any time the "fetch" slash command is used

import com.watson.Sorti.Models.Attachment;
import com.watson.Sorti.Models.SlackResponseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping(value = "/slack/fetch",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SlackResponseModel onReceiveSlashCommand(@RequestParam("team_id") String teamId,
                                               @RequestParam("team_domain") String teamDomain,
                                               @RequestParam("channel_id") String channelId,
                                               @RequestParam("channel_name") String channelName,
                                               @RequestParam("user_id") String userId,
                                               @RequestParam("user_name") String userName,
                                               @RequestParam("command") String command,
                                               @RequestParam("text") String text,
                                               @RequestParam("response_url") String responseUrl) {
        SlackResponseModel response = new SlackResponseModel();
        response.setText("This is the response text");
        //Response type "in-channel" is seen by everyone in the channel
        //Response type "ephemeral" is seen only by user--also default setting if not manually set to "in-channel"
        response.setResponseType("ephemeral");

        Attachment attachment = new Attachment();
        attachment.setText("This is the attachment text");
        attachment.setColor("#0000ff");

        response.attachments.add(attachment);

        return response;
    }
}
