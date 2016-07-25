package com.patapin.djmojo.soundbox.model;

import com.patapin.djmojo.soundbox.listener.ClickButton;

/**
 * Created by DJMojo on 20/12/2014.
 */
public class ButtonInfos {

    private int buttonId;
    private int soundId;
    private int statTextId;
    private ClickButton click;
    private String prefCounter;

    public ButtonInfos(int buttonId, int soundId, int statTextId, String prefCounter) {
        this.buttonId = buttonId;
        this.soundId = soundId;
        this.statTextId = statTextId;
        this.prefCounter = prefCounter;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }

    public int getStatTextId() {
        return statTextId;
    }

    public void setStatTextId(int statTextId) {
        this.statTextId = statTextId;
    }

    public ClickButton getClick() {
        return click;
    }

    public void setClick(ClickButton click) {
        this.click = click;
    }

    public String getPrefCounter() {
        return prefCounter;
    }

    public void setPrefCounter(String prefCounter) {
        this.prefCounter = prefCounter;
    }
}
