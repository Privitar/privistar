package com.privitar.privistar;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

public enum PrivistarIcon {
    NYAN,
    FEDE,
    PAUL;

    public Icon getForwardIcon() {
        return IconLoader.getIcon(getPath(), PrivistarIcon.class);
    }

    public Icon getBackwardIcon() {
        return new MirroredIcon(getForwardIcon());
    }

    private String getPath() {
        return "icons/" + name().toLowerCase() + ".png";
    }
}
