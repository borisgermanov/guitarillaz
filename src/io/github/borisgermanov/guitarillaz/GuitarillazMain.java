/**
 * bo 20160923
 * https://borisgermanov.github.io/guitarillaz/
 */

package io.github.borisgermanov.guitarillaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *
 */
public class GuitarillazMain {
    private JRadioButton radioButtonClean;
    private JRadioButton radioButtonCrunch;
    private JRadioButton radioButtonDistortion;
    private JPanel panelMain;
    private JPanel panelChannel;
    private JLabel testLabel;
    private JLabel testLabel2;
    private ButtonGroup buttonGroupChannel;

    private class Config extends GuitarillazConfig {
        Config() {
            switch (getChannel()) {
                case CRUNCH:
                    radioButtonCrunch.setSelected(true);
                    break;
                case DISTORTION:
                    radioButtonDistortion.setSelected(true);
                    break;
                case CLEAN:
                default:
                    radioButtonClean.setSelected(true);
                    break;
            }

            testLabel.setText(getChannel().toString());
        }

        @Override
        public void setChannel(Channel channel) {
            super.setChannel(channel);
            testLabel.setText(getChannel().toString());
        }
    }

    public GuitarillazMain() {
        Config config = new Config();

        radioButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(Config.Channel.CLEAN);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });
        radioButtonCrunch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(Config.Channel.CRUNCH);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });
        radioButtonDistortion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(Config.Channel.DISTORTION);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });
    }

    private ArrayList<Image> getIconImages() {
        ArrayList<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/res/icon/guitarillaz_16.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/res/icon/guitarillaz_32.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/res/icon/guitarillaz_64.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/res/icon/guitarillaz_128.png")).getImage());
        return icons;
    }

    public static void main(String[] args) {
        GuitarillazMain guitarillazMain = new GuitarillazMain();
        JFrame mainFrame = new JFrame(ResourceBundle.getBundle("res/guitarillaz").getString("app.Name"));
        mainFrame.setContentPane(guitarillazMain.panelMain);
        mainFrame.setIconImages(guitarillazMain.getIconImages());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
