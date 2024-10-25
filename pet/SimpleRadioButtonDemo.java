import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleRadioButtonDemo extends JFrame {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel displayLabel;
    private ButtonGroup group;

    public SimpleRadioButtonDemo() {
        // Create the radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Set a default selection
        birdButton.setSelected(true); // Set Bird as the default selected button

        // Create a panel and add the radio buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(birdButton);
        panel.add(catButton);
        panel.add(dogButton);
        panel.add(rabbitButton);
        panel.add(pigButton);

        // Create the display label
        displayLabel = new JLabel("You selected: Bird", JLabel.CENTER); // Initial message

        // Add action listeners to the buttons
        birdButton.addActionListener(new RadioListener());
        catButton.addActionListener(new RadioListener());
        dogButton.addActionListener(new RadioListener());
        rabbitButton.addActionListener(new RadioListener());
        pigButton.addActionListener(new RadioListener());

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.WEST);
        add(displayLabel, BorderLayout.CENTER);

        // Frame settings
        setTitle("Pet Selector");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Listener for radio button selection
    private class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            displayLabel.setText("You selected: " + selectedButton.getText());
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> new SimpleRadioButtonDemo());
    }
}
