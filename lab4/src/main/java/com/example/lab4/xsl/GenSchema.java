package com.example.lab4.xsl;

import com.example.lab4.xsl.dto.PostList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class GenSchema {
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(PostList.class);
//        JAXBContext jc = JAXBContext.newInstance(UserList.class);

        jc.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceURI, String suggestedFileName)
                    throws IOException {
                StreamResult result = new StreamResult(System.out);
                result.setSystemId(suggestedFileName);
                return result;
            }
        });
    }
}