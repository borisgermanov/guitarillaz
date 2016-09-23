/*
 * bo 20160923
 * https://borisgermanov.github.io/guitarillaz/
 */

package io.github.borisgermanov.guitarillaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;

/*
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

    private GuitarillazMain() {
        Config config = new Config();

        radioButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(GuitarillazConfig.Channel.CLEAN);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });
        radioButtonCrunch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(GuitarillazConfig.Channel.CRUNCH);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });
        radioButtonDistortion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                config.setChannel(GuitarillazConfig.Channel.DISTORTION);
                testLabel2.setText(actionEvent.getActionCommand());
            }
        });

        /*
        final List<Image> icons = new ArrayList<Image>();
        try {
            icons.add(ImageIO.read(getClass().getResource("guitarillaz_16.png")));
            icons.add(ImageIO.read(getClass().getResource("guitarillaz_32.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Guitarillaz");
        GuitarillazMain guitarillazMain = new GuitarillazMain();

        mainFrame.setContentPane(guitarillazMain.panelMain);
        /*
        mainFrame.setIconImages(guitarillazMain.icons);
        */
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}