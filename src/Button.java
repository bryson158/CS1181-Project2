import javax.swing.*;

public class Button extends JButton
{
    ImageIcon X,O;

    // Prepares X and O images for placing
    public Button()
    {
        X =new ImageIcon(this.getClass().getResource("X.png"));
        O =new ImageIcon(this.getClass().getResource("O.png"));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    // Inserts X and O images into board
    public void setImaIcon(String icon)
    {
        if (icon.equals("-"))
        {
            setIcon(null);
        }
        else if (icon.equals("X"))
        {
            setIcon(X);
        }
        else if (icon.equals("O"))
        {
            setIcon(O);
        }
    }
}
