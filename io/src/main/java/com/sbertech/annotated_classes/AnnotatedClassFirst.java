package com.sbertech.annotated_classes;

import com.sbertech.DataContainer;
import com.sbertech.annotations.repeated_annotation.RepeatedAnnotation;
import lombok.NonNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AnnotatedClassFirst extends AnnotatedClassBase {

    private static final String LOGS_DIR_PATH = "./logs";

    @RepeatedAnnotation(hour = 10, priority = 1, description = "method 1")
    public void doStuff1(@NonNull DataContainer arg1) throws IOException {
        createFileByDate("doStuff1 method has been invoked");
    }

    @RepeatedAnnotation(hour = 15, priority = 2, description = "method 2")
    @RepeatedAnnotation(hour = 20, priority = 2, description = "method 2 copy")
    public void doStuff2(@NonNull DataContainer arg2) throws IOException {
        createFileByDate("doStuff2 method has been invoked");
    }

    private boolean createFileByDate(String fileContent) throws IOException {
        String generatedFileName = String.format("file - %s.txt", new Date());
        String filePath = LOGS_DIR_PATH + "/" + generatedFileName;

        File newFile = new File(filePath);

        if (!newFile.createNewFile()) {
            System.out.printf("File with name %s already exists\n", generatedFileName);
            return false;
        }

        System.out.printf("File with name %s was created\n", generatedFileName);

        try(var fw = new FileWriter(filePath)) {
            fw.write(fileContent);
        }

        // Check files count in target directory
        List<File> files = Arrays.stream(Objects.requireNonNull(new File(LOGS_DIR_PATH).listFiles()))
                .filter(File::isFile)
                .toList();

        if (files.size() > 2) {
            files.forEach(File::delete);
        }

        return true;
    }
}
