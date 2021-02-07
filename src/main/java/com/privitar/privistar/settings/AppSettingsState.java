// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.privitar.privistar.settings;

import static com.privitar.privistar.PrivistarIcon.PAUL;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.privitar.privistar.PrivistarIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way. The {@link State} and {@link Storage} annotations define the name of the data and the file
 * name where these persistent application settings are stored.
 */
@State(
        name = "com.privitar.privistar",
        storages = {@Storage("PrivistarPlugin.xml")}
)
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    private PrivistarIcon privistarIcon = PAUL;

    public static AppSettingsState getInstance() {
        return ServiceManager.getService(AppSettingsState.class);
    }

    @Nullable
    @Override
    public AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public PrivistarIcon getPrivistarIcon() {
        return privistarIcon;
    }

    public void setPrivistarIcon(PrivistarIcon privistarIcon) {
        this.privistarIcon = privistarIcon;
    }
}