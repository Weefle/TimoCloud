package cloud.timo.TimoCloud.base.objects;

import org.json.simple.JSONObject;

public class BaseServerObject {
    private String name;
    private String group;
    private int ram;
    private boolean isStatic;
    private String map;
    private String token;
    private JSONObject templateHash;
    private JSONObject mapHash;
    private JSONObject globalHash;

    public BaseServerObject(String name, String group, int ram, boolean isStatic, String map, String token, JSONObject templateHash, JSONObject mapHash, JSONObject globalHash) {
        this.name = name;
        this.group = group;
        this.ram = ram;
        this.isStatic = isStatic;
        this.map = map;
        this.token = token;
        this.templateHash = templateHash;
        this.mapHash = mapHash;
        this.globalHash = globalHash;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getRam() {
        return ram;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public String getMap() {
        return map;
    }

    public String getToken() {
        return token;
    }

    public JSONObject getTemplateHash() {
        return templateHash;
    }

    public JSONObject getMapHash() {
        return mapHash;
    }

    public JSONObject getGlobalHash() {
        return globalHash;
    }
}
