package com.privitar.privistar;

import com.intellij.ide.ui.LafManager;
import javax.swing.UIManager;


public class PrivistarApplicationComponent {

    public PrivistarApplicationComponent() {
        LafManager.getInstance().addLafManagerListener(__ -> updateProgressBarUi());
        updateProgressBarUi();
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", ProgressBar.class.getName());
        UIManager.getDefaults().put(ProgressBar.class.getName(), ProgressBar.class);
    }
}
