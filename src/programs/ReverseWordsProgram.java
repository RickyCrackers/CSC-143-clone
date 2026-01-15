package programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author A. Ford and Tran Gia Huy (Ricky)
 * A program that takes a text file and reverse the words in each line and print the result on a new file.
 */

public class ReverseWordsProgram {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println("\t R  E  V  E  R  S  E    W  O  R  D  S    ");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    /**
     * Reads in an empty list and file location and populates list with
     * the lines and words reversed.
     *
     * @param inputLocation             for reading in the file information
     * @param list                      to be populated
     * @throws FileNotFoundException    if file location not found
     */
    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{
        //TODO: check if input location exists
        validateInputFile(inputLocation);

        //TODO: Create a File Object
        File file = new File(inputLocation);

        //TODO: Opens up a file input stream
        FileInputStream fileInputStream = new FileInputStream(file);

        //TODO: store words in reverse in a list from each line
        //TODO: read in the data using input scanner
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            //TODO: read in next line and store as a string
            String line = scanner.nextLine();

            //TODO: get each word on each line using a delimiter and store in index location
            String[] words = line.split("\\s+");

            //TODO: store words in reverse
            //TODO: use string builder to build out lines with space
            StringBuilder reversedLine = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversedLine.append(words[i]);
                if (i > 0) {
                    reversedLine.append(" ");
                }
            }

            //TODO: add each reversed line to list as a string
            list.add(reversedLine.toString());

            //TODO: clear the words on each line
        }
        scanner.close();
    }

    /**
     * Checks whether the file exists.
     * @param location                  of file is checked
     * @throws FileNotFoundException    if file does not exist
     */
    public static void validateInputFile(String location) throws FileNotFoundException{

        File inputFile = new File(location);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("File at " + location + " does not exist.");
        }

        System.out.println("Processing \t" + location + "...");

    }

    /**
     * Checks whether the output directory exists.
     * @param outputFolder for output file
     */
    public static void validateOutputFolder(String outputFolder) {
        File folder = new File(outputFolder);

        if (!folder.exists()) {

            boolean hasCreatedDirectory = folder.mkdir();
            System.out.println("Has the directory been created? " + hasCreatedDirectory);
            System.out.println();

            if (hasCreatedDirectory) {
                System.out.println("Processing \t" + outputFolder + "...");
            }else {
                System.out.println("something went wrong.....");
            }
        } else {
            System.out.println("Processing \t" + outputFolder + "...");
        }

    }

    /**
     * Writes to an output file.
     * @param outputLocation to where output file exists
     * @param list containing reversed words
     * @throws FileNotFoundException when cannot write to output location
     */
    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{

        //TODO: Open up a file output stream
        FileOutputStream fileOutputStream = new FileOutputStream(outputLocation);

        // TODO: write out lines using  Print Stream -> write
        PrintStream printStream = new PrintStream(fileOutputStream);
        for (String line : list) {
            printStream.println(line);
        }

        //TODO: close output stream
        printStream.close();
    }

    /**
     * Program Main method.
     * @param args      command line arguments
     * @throws FileNotFoundException    if file location not found
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException {
        intro();

        String inputFile = "."  + File.separator + "data"
                                + File.separator + "words.txt";

        String outputFolder = "." + File.separator + "results";

        String outputFile = "." + File.separator + "results"
                                + File.separator + "reverse_words.txt";

        // TODO: update program to use an Array List
        List<String> list = new ArrayList<>();

        // TODO: process items in file (REVERSALS, can be done either in main or in read)
        read(inputFile, list);

        // TODO: Validate Output Directory Exists and write to results folder
        validateOutputFolder(outputFolder);
        write(outputFile, list);
    }


}
