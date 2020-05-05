package com.development5053.antiplagiarism.util.multipartFileParces;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MultipartFileParcer {

    public static String parceMultipartFile(MultipartFile file) throws IOException {
        StringBuilder lines = new StringBuilder();
        String line;
        InputStream inputStream = file.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = bufferedReader.readLine()) != null) {
            lines.append(line).append("\n");
        }
        return lines.toString();
    }

}
