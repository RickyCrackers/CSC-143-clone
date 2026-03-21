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
    private int minIndex = 0;   // Tracks minimum index for Selection Sort

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
        JButton resetButton = new JButton("Reset");


        // Set the sorting algorithm to test/visualize
        algorithmSelector.addActionListener(_ -> selectAlgorithm());
        currentAlgorithm    = "Bubble Sort";

        // Set the listener to be checking time intervals by time DELAY
        startButton.addActionListener(_ -> startTimer());
        resetButton.addActionListener(_ -> resetData());

        // Add Button and ComboBox to JPanel
        controlPanel.add(startButton);
        controlPanel.add(resetButton);
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

    // -------------------------------------------------------------------------
    // Animation dispatcher
    // -------------------------------------------------------------------------

    private void animate() {

        switch (currentAlgorithm) {

            case "Bubble Sort"    -> bubbleSortStep();
            case "Insertion Sort" -> insertionSortStep();
            case "Selection Sort" -> selectionSortStep();

            default -> stopTimer();
        }

    }

    // -------------------------------------------------------------------------
    // Bubble Sort  –  O(n²)
    //   Repeatedly compares adjacent elements and swaps them when out of order.
    //   Each full pass "bubbles" the largest unsorted value to the right end.
    // -------------------------------------------------------------------------

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

    // -------------------------------------------------------------------------
    // Insertion Sort  –  O(n²)
    //   Builds a sorted sub-array on the left one element at a time.
    //   Each new element is shifted left until it reaches its correct position.
    //
    //   State variables reused:
    //     i  = the current element being inserted  (outer index, starts at 1)
    //     j  = the position being compared / shifted (inner index, walks left)
    // -------------------------------------------------------------------------

    private void insertionSortStep() {

        // Advance i until we find an unsorted element to place
        if (i < data.length) {

            if (j > 0 && data[j - 1] > data[j]) {

                updateComparison(j - 1, j);
                swap(j - 1, j);
                j--;
                sortPanel.repaint();

            } else {
                // Current element is in its correct position – move to the next
                i++;
                j = i;
                sortPanel.repaint();
            }

        } else {
            stopTimer();
        }
    }

    // -------------------------------------------------------------------------
    // Selection Sort  –  O(n²)
    //   Scans the unsorted portion to find the minimum element, then swaps it
    //   into the first unsorted position.  Repeats for each position left to right.
    //
    //   State variables reused:
    //     i        = start of unsorted region (outer index)
    //     j        = scanner index within unsorted region (inner index)
    //     minIndex = index of the current minimum found
    // -------------------------------------------------------------------------

    private void selectionSortStep() {

        if (i < data.length - 1) {

            if (j < data.length) {

                updateComparison(j, minIndex);

                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
                j++;
                sortPanel.repaint();

            } else {
                // Swap the found minimum into position i
                if (minIndex != i) {
                    swap(i, minIndex);
                    updateComparison(i, minIndex);
                    sortPanel.repaint();
                }

                // Advance outer index and reset scanner
                i++;
                j        = i + 1;
                minIndex = i;
            }

        } else {
            stopTimer();
        }
    }

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

    private void resetData() {
        timer.stop();
        isSorted = false;
        setDataSize();
        int[] freshData = generateRandomArray(size);
        System.arraycopy(freshData, 0, data, 0, Math.min(freshData.length, data.length));
        resetStateVariables();
        sortPanel.setCurrentComparison(-1, -1);
        sortPanel.repaint();
        System.out.println("Data reset.");
    }

    private void resetStateVariables() {
        i        = 0;
        j        = 1;           // Insertion sort begins its inner scan at index 1
        minIndex = 0;
    }


    private void startTimer() {
        if (!isSorted) {
            isSorted = true;
            resetStateVariables();
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
