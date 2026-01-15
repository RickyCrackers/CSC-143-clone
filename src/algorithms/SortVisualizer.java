package algorithms;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.io.Serial;
import java.util.Random;

public class SortVisualizer extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private final JComboBox<String>   algorithmSelector;
    private String                    currentAlgorithm;
    private final JButton             startButton;
    private final SortPanel           sortPanel;
    private final Timer               timer;
    private final int[]               data;
    private int size;

    private int i = 0; // Outer loop index
    private int j = 0; // Inner loop index

    private boolean isSorted = false;
    private final static int DELAY = 200; // ms

    public SortVisualizer() {
        // Set up the Main GUI Window
        setTitle("Sorting Visualizer");
        setSize(800, 600);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setup control panel and button
        JPanel controlPanel = new JPanel();
        algorithmSelector   = new JComboBox<>(new String[]{"Bubble Sort", "Insertion Sort", "Selection Sort"});
        startButton         = new JButton("Start");

        // Set the sorting algorithm to test/visualize
        algorithmSelector.addActionListener(_ -> selectAlgorithm());
        currentAlgorithm    = "Bubble Sort";

        // Set the listener to be checking time intervals by time DELAY
        startButton.addActionListener(_ -> startTimer());

        // Add Button and ComboBox to JPanel
        controlPanel.add(startButton);
        controlPanel.add(algorithmSelector);

        // Initialize data to place on SortPanel
        setDataSize();
        data        = generateRandomArray(size);
        sortPanel   = new SortPanel(data);

        // Add panels to window JFrame
        add(sortPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Set up Timer for animation updates by time DELAY
        timer = new Timer(DELAY, _ -> animate()); // 1000 ms delay
    }

    static void main() {
        // Ensure GUI creation happens on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            SortVisualizer window = new SortVisualizer();
            window.setVisible(true);
        });
    }

    private void animate() {

        switch (currentAlgorithm) {

            case "Bubble Sort"    -> bubbleSortStep();
            case "Insertion Sort" -> insertionSortStep();
            case "Selection Sort" -> selectionSortStep();

            default -> stopTimer();
        }

    }

    // This method manages the single step of the current sort algorithm
    //  uses state variables (like 'i' and 'j' in bubble sort)
    private void bubbleSortStep() {
        if (i < data.length - 1) {
            if (j < data.length - i - 1) {
                // Request a repaint after each step (Highlight bars)
                updateComparison(j, j + 1);

                if (data[j] > data[j + 1]) {
                    swap(j, j + 1);
                    // Request a repaint after each swap (Highlight bars)
                    updateComparison(j, j + 1);
                }
                j++;
            } else {
                // Inner loop finished, reset j and increment i
                j = 0;
                i++;
            }
            // Request a repaint
            sortPanel.repaint();
        } else {
            stopTimer();
        }
    }

    private void insertionSortStep() { bubbleSortStep();}
    private void selectionSortStep() { bubbleSortStep();}

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();

        for (int k = 0; k < size; k++) {
            array[k] = rand.nextInt(500) + 10; // Values between 10 and 510
        }
        return array;
    }

    private void setDataSize() {
        Random rand = new Random();
        size = rand.nextInt(15) + 10;         // Values between 10 and 25
    }

    private void selectAlgorithm() {
        currentAlgorithm    = (String) algorithmSelector.getSelectedItem();

        switch (currentAlgorithm) {
            case "Bubble Sort", "Insertion Sort", "Selection Sort" -> System.out.println("\n>> " + currentAlgorithm);
            case null, default -> currentAlgorithm = "Bubble Sort";
        }
    }


    private void startTimer() {
        if (!isSorted) {
            isSorted = true;
            timer.start();
        }
    }

    private void stopTimer() {
        // Sorting is complete
        timer.stop();
        isSorted = false;
        sortPanel.setCurrentComparison(-1, -1);
        sortPanel.repaint();
        System.out.println("Sorting Finished!");
    }

    private void swap (int a, int b){
        // Perform the swap
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private void updateComparison ( int a, int b){
        // Request a repaint after each step/swap
        sortPanel.setCurrentComparison(a, b); // Highlight bars
        sortPanel.repaint();
    }

}
