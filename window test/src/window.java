
// This project demonstrates some helpful features for game development using Java JDK 21:
// - Creating a window
// - Setting a window title
// - Adding a custom window icon
// - Toggling fullscreen mode with Alt + Enter
//
// Note: This project does not include a 3D system. 
// Currently, it works in 2D, but you can add libraries and code to implement 3D functionality.
//
// You can see what each part of this project does from the explanatory comments
// and you can modify or add features as you wish.
//
// I hope you like it and that it helps in your own games.
// Don't forget to subscribe to my YouTube channel "MPEG4-MAN".
// Happy coding!

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Needed for KeyEvent and ActionEvent

public class Window {
    public static void main(String[] args) {
        // -------------------------------
        // Create the JFrame (main window)
        // -------------------------------
        JFrame frame = new JFrame("SUBSCRIBE TO MPEG4-MAN"); // Window title
        frame.setSize(1920, 1080); // Initial window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when X is clicked

        // -------------------------------
        // Set a custom icon for the window
        // -------------------------------
        ImageIcon icon = new ImageIcon("icon.png"); // Make sure icon.png is in your project folder
        frame.setIconImage(icon.getImage()); // Set the icon image for the JFrame
        // If you don't want an icon, you can remove the two lines above

        // ------------------------------------------------------
        // Key Binding: Alt + Enter toggles Fullscreen mode
        // ------------------------------------------------------
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "toggleFullscreen");

        frame.getRootPane().getActionMap().put("toggleFullscreen", new AbstractAction() {
            boolean fullscreen = false; // Track fullscreen state
            Dimension windowedSize = frame.getSize(); // Store original window size
            Point windowedLocation = frame.getLocation(); // Store original window location

            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle fullscreen state
                fullscreen = !fullscreen;

                frame.dispose(); // Needed to change undecorated state
                frame.setUndecorated(fullscreen); // Remove window borders in fullscreen

                if (fullscreen) {
                    // Maximize the window to full screen
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                } else {
                    // Restore original window size and position
                    frame.setSize(windowedSize);
                    frame.setLocation(windowedLocation);
                }

                frame.setVisible(true); // Make the window visible again after changes
            }
        });

        // -----------------------------------------
        // Make the window visible to the user
        // -----------------------------------------
        frame.setVisible(true);
    }
}
