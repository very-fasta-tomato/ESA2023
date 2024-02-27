package com.example.lab3.xsl;

import com.example.lab3.repo.PostRepository;
import com.example.lab3.repo.UserRepository;
import com.example.lab3.xsl.dto.Post;
import com.example.lab3.xsl.dto.PostList;
import com.example.lab3.xsl.dto.User;
import com.example.lab3.xsl.dto.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

@Controller
@RequestMapping(value = "xsl")
public class XslTransformController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private UserList getAllUsers() {
        UserList list = new UserList();
        var userList = list.getUsers();
        for (var user : userRepository.findAll()) {
            userList.add(new User(user));
        }
        return list;
    }

    private PostList getAllPosts() {
        PostList list = new PostList();
        var userList = list.getPosts();
        for (var post : postRepository.findAll()) {
            userList.add(new Post(post));
        }
        return list;
    }

    @GetMapping(path = "/user")
    private ModelAndView getUser() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(getAllUsers(), stringWriter);
        Source xmlSource = new StreamSource(new StringReader(stringWriter.toString()));
        return new ModelAndView("userXSL").addObject(xmlSource);
    }

    @GetMapping(path = "/post")
    private ModelAndView getPost() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PostList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(getAllPosts(), stringWriter);
        Source xmlSource = new StreamSource(new StringReader(stringWriter.toString()));
        return new ModelAndView("postXSL").addObject(xmlSource);
    }
}