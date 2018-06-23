package com.ckai.samples.protobuf;

import com.ckai.samples.protobuf.model.ContactProto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contacts")
public class ContactController {


    @GetMapping(value = "/current",
        produces = {
            "application/x-protobuf",
            MediaType.APPLICATION_JSON_UTF8_VALUE,
        })
    public ContactProto.Contact getCurrentContact() {

        return ContactProto.Contact.newBuilder()
            .setFirstName("Kai")
            .setLastName("Chen")
            .setEmail("kai@ckai.com")
            .setGithubLink("github.com/xmkevinchen")
            .setType(ContactProto.Contact.ContactType.ATTENDANT)
            .setImageName("kai.png")
            .build();
    }

    @GetMapping(value = "/speakers", produces = {
        "application/x-protobuf",
        MediaType.APPLICATION_JSON_UTF8_VALUE,
    })
    public ContactProto.Speakers getSpeakers() {

        List<ContactProto.Contact> speakers = Arrays.asList(
            ContactProto.Contact.newBuilder()
                .setFirstName("Kai")
                .setLastName("Chen")
                .setEmail("kai@ckai.com")
                .setGithubLink("github.com/xmkevinchen")
                .setTwitterName("@xmkevinchen")
                .setType(ContactProto.Contact.ContactType.SPEAKER)
                .setImageName("kai.png")
                .build(),
            ContactProto.Contact.newBuilder()
                .setFirstName("Kai")
                .setLastName("Chen")
                .setEmail("kai@ckai.com")
                .setGithubLink("github.com/xmkevinchen")
                .setType(ContactProto.Contact.ContactType.SPEAKER)
                .setImageName("kai.png")
                .build()
        );

        return ContactProto.Speakers.newBuilder()
            .addAllSpeakers(speakers)
            .build();
    }


}
