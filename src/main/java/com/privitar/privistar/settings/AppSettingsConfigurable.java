// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.privitar.privistar.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent appSettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Privistar Progress Bar";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return appSettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        appSettingsComponent = new AppSettingsComponent();
        return appSettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        return !appSettingsComponent.getPrivistarIcon().equals(AppSettingsState.getInstance().getPrivistarIcon());
    }

    @Override
    public void apply() {
        AppSettingsState.getInstance().setPrivistarIcon(appSettingsComponent.getPrivistarIcon());
    }

    @Override
    public void reset() {
        appSettingsComponent.setPrivistarIcon(appSettingsComponent.getPrivistarIcon());
    }

    @Override
    public void disposeUIResources() {
        appSettingsComponent = null;
    }

}