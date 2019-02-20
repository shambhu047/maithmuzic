package com.maithmuzic.common.db.helper.session;

import java.util.Map;

public class Client {
    private Platform platform;

    private OS os;

    private Map<String, String> miscellaneousInfo;

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Map<String, String> getMiscellaneousInfo() {
        return miscellaneousInfo;
    }

    public void setMiscellaneousInfo(Map<String, String> miscellaneousInfo) {
        this.miscellaneousInfo = miscellaneousInfo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "platform=" + platform +
                ", os=" + os +
                ", miscellaneousInfo=" + miscellaneousInfo +
                '}';
    }
}
