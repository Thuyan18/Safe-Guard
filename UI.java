import javax.swing.*;
import java.awt.*;

public class HomeUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel timeLabel = new JLabel("10:11");
        JLabel welcomeLabel = new JLabel("Welcome Back, Leoheart!");
        
        topPanel.add(timeLabel);
        topPanel.add(welcomeLabel);
        
        JPanel mapPanel = new JPanel();
        mapPanel.setPreferredSize(new Dimension(350, 200));
        mapPanel.setBackground(Color.WHITE);
        JLabel mapLabel = new JLabel("[Map Placeholder]");
        mapPanel.add(mapLabel);
        
        JPanel friendsPanel = new JPanel();
        friendsPanel.setLayout(new FlowLayout());
        friendsPanel.setBackground(Color.LIGHT_GRAY);
        
        friendsPanel.add(new JLabel("Your Friends:"));
        friendsPanel.add(new JLabel(new ImageIcon("liz.png"))); 
        friendsPanel.add(new JLabel(new ImageIcon("jean.png"))); 
        friendsPanel.add(new JLabel(new ImageIcon("sasha.png"))); 
        
        JPanel bottomNav = new JPanel();
        bottomNav.setLayout(new GridLayout(1, 5));
        JButton homeButton = new JButton("HOME");
        JButton chatButton = new JButton("💬");
        JButton mapButton = new JButton("📍");
        JButton alertButton = new JButton("⚠");
        JButton settingsButton = new JButton("⚙");
        
        bottomNav.add(homeButton);
        bottomNav.add(chatButton);
        bottomNav.add(mapButton);
        bottomNav.add(alertButton);
        bottomNav.add(settingsButton);
        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mapPanel, BorderLayout.CENTER);
        frame.add(friendsPanel, BorderLayout.SOUTH);
        frame.add(bottomNav, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}
