// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.privitar.privistar.settings;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import com.privitar.privistar.PrivistarIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class AppSettingsComponent {

    private final JPanel myMainPanel;
    private final ComboBox<PrivistarIcon> privistarIconComboBox = createPrivistarList();

    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addComponent(privistarListWithLabel())
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    private JComponent privistarListWithLabel() {
        JPanel rowPanel = new JPanel();
        rowPanel.add(new JLabel("My favourite Privistar:"));
        rowPanel.add(privistarIconComboBox);
        return rowPanel;
    }

    private ComboBox<PrivistarIcon> createPrivistarList() {
        ComboBox<PrivistarIcon> comboBox = new ComboBox<>(PrivistarIcon.values());
        comboBox.setRenderer((list, value, index, isSelected, cellHasFocus) -> new JBLabel(value.name()));
        comboBox.setSelectedItem(AppSettingsState.getInstance().getPrivistarIcon());
        return comboBox;
    }

    public JComponent getPreferredFocusedComponent() {
        return privistarIconComboBox;
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public PrivistarIcon getPrivistarIcon() {
        return (PrivistarIcon) privistarIconComboBox.getSelectedItem();
    }

    public void setPrivistarIcon(PrivistarIcon privistarIcon) {
        privistarIconComboBox.setSelectedItem(privistarIcon);
    }
}