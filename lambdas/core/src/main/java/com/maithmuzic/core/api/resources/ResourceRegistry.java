package com.maithmuzic.core.api.resources;

import com.maithmuzic.core.api.action.Greetings;
import com.maithmuzic.core.api.handler.IActionHandler;
import com.maithmuzic.core.api.restfull.ResourceAction;

import java.util.HashMap;
import java.util.Map;

public class ResourceRegistry {
    private static Map<String, Resource> registry = new HashMap<>();

    public static void addResource(String resourceName, Map<ResourceAction, Class<? extends IActionHandler>> actionsHandlers) {
        registry.put(resourceName, new Resource(actionsHandlers));
    }

    public static void addResource(String resourceName, Resource actionHandlers) {
        registry.put(resourceName, actionHandlers);
    }

    public static void addResource(String resourceName) {
        registry.put(resourceName, new Resource());
    }

    public static Resource getResource(String resourceName) {
        return registry.get(resourceName);
    }

    public static Class<? extends IActionHandler> getActionHandler(String resourceName, ResourceAction action) {
        Class<? extends IActionHandler> handler = null;

        if (registry.get(resourceName) != null) {
            handler = registry.get(resourceName).getHandler(action);
        }

        return handler;
    }

    public static boolean isResourceAvalable(String resourceName) {
        return registry.get(resourceName) != null;
    }

    public static boolean isActionAllowed(String resourceName, ResourceAction action) {
        boolean isSupported = false;

        if (registry.get(resourceName) != null) {
            isSupported = registry.get(resourceName).isActionAllowed(action);
        }

        return isSupported;
    }

    // FIXME:
    public static boolean isResourceSecure(String resourceName) {
        return registry.get(resourceName) != null && registry.get(resourceName).isSecure();
    }

    static {
        try {
            Resource r = new Resource();
            r.addAction(ResourceAction.GET, Greetings.class);
            registry.put("/greetings", r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
