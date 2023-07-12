package com.sbertech;

import com.sbertech.annotated_classes.AnnotatedClassFirst;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final String LOGS_DIR_PATH = "./logs";

    public static void main(String[] args) {
        File logsDir = new File(LOGS_DIR_PATH);

        if (!logsDir.exists()) {
            logsDir.mkdirs();
        }

        AnnotatedClassFirst classSecond = new AnnotatedClassFirst();
        DataContainer dataContainer = new DataContainer();

        try {
            classSecond.doStuff1(dataContainer);
            classSecond.doStuff1(dataContainer);

            classSecond.doStuff2(dataContainer);
            classSecond.doStuff2(dataContainer);
        } catch (IOException e) {
            System.out.println("Error while creating or writing to file");
            e.printStackTrace();
        }
    }
}