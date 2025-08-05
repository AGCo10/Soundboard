import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SoundboardGUI extends JFrame implements ActionListener {

    private JButton airhorn; // Add more buttons as needed
    private Clip clip1; // Add more clips for each sound

    public SoundboardGUI() {
        setTitle("Java Soundboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.GridLayout(2, 2)); // Example layout

        // Initialize buttons
        airhorn = new JButton("Airhorn");

        // Add action listeners
        airhorn.addActionListener(this);

        // Add buttons to the frame
        add(airhorn);

        // Load sounds
        try {
            clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(new File("/Users/a2473390/Desktop/Soundbites/airhorn.wav")));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading sound files: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == airhorn) {
            if (clip1 != null) {
                clip1.setFramePosition(0); // Rewind to start
                clip1.start();
            }
        }
        }

}