package com.maithmuzic.core.api.resources;

import com.maithmuzic.core.api.action.Greetings;
import com.maithmuzic.core.api.handler.IActionHandler;
import com.maithmuzic.core.api.restfull.ResourceAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Resource {
    private Map<ResourceAction, Class<? extends IActionHandler>> actionsHandlers;

    private boolean isSecure;

    public Resource() {
        this(true, new HashMap<>());
    }

    public Resource(Map<ResourceAction, Class<? extends IActionHandler>> actionsHandlers) {
        this(true, actionsHandlers);
    }

    public Resource(boolean isSecure, Map<ResourceAction, Class<? extends IActionHandler>> actionsHandlers) {
        this.isSecure = isSecure;
        this.actionsHandlers = actionsHandlers;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public boolean isActionAllowed(ResourceAction action) {
        return actionsHandlers.get(action) != null;
    }

    public List<ResourceAction> availableActions() {
        return actionsHandlers.keySet().stream().collect(Collectors.toList());
    }

    public Class<? extends IActionHandler> getHandler(ResourceAction action) {
        return actionsHandlers.get(action);
    }

    public void addAction(ResourceAction action, Class<? extends IActionHandler> handlerClass) {
        actionsHandlers.put(action, handlerClass);
    }

    public void addActions(Map<ResourceAction, Class<? extends IActionHandler>> actions) {
        actions.entrySet().forEach(a -> actionsHandlers.put(a.getKey(), a.getValue()));
    }
}
