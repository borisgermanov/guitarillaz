/*
 * Copyright 2016 bo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * bo 20160923
 * https://borisgermanov.github.io/guitarillaz/
 */

package io.github.borisgermanov.guitarillaz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Guitarilazz main window class
 */
public class GuitarillazMain {
    private JRadioButton radioButtonClean;
    private JRadioButton radioButtonCrunch;
    private JRadioButton radioButtonDistortion;
    private JPanel panelMain;
    private JPanel panelChannel;
    private JLabel testLabel;
    private JLabel testLabel2;
    private JSlider sliderGain;
    private JSlider sliderVolume;
    private JProgressBar progressBarLevel;
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
        sliderGain.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                testLabel2.setText(String.valueOf(((int)(((JSlider)e.getSource()).getValue()))));
            }
        });
        sliderVolume.addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {

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
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);
    }
}
