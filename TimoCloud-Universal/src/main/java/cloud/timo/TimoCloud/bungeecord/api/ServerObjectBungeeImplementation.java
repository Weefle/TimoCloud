package cloud.timo.TimoCloud.bungeecord.api;

import cloud.timo.TimoCloud.api.implementations.ServerObjectBasicImplementation;
import cloud.timo.TimoCloud.api.objects.PlayerObject;
import cloud.timo.TimoCloud.api.objects.ServerObject;
import cloud.timo.TimoCloud.bungeecord.TimoCloudBungee;

import java.net.InetSocketAddress;
import java.util.List;

public class ServerObjectBungeeImplementation extends ServerObjectBasicImplementation implements ServerObject {

    public ServerObjectBungeeImplementation() {}

    public ServerObjectBungeeImplementation(String name, String group, String token, String state, String extra, String map, String motd, List<PlayerObject> onlinePlayers, int onlinePlayerCount, int maxPlayerCount, String base, InetSocketAddress socketAddress) {
        super(name, group, token, state, extra, map, motd, onlinePlayers, onlinePlayerCount, maxPlayerCount, base, socketAddress);
    }

    public ServerObjectBungeeImplementation(ServerObjectBasicImplementation serverObjectBasicImplementation) {
        this(
                serverObjectBasicImplementation.getName(),
                serverObjectBasicImplementation.getGroupName(),
                serverObjectBasicImplementation.getToken(),
                serverObjectBasicImplementation.getState(),
                serverObjectBasicImplementation.getExtra(),
                serverObjectBasicImplementation.getMap(),
                serverObjectBasicImplementation.getMotd(),
                serverObjectBasicImplementation.getOnlinePlayers(),
                serverObjectBasicImplementation.getOnlinePlayerCount(),
                serverObjectBasicImplementation.getMaxPlayerCount(),
                serverObjectBasicImplementation.getBase(),
                serverObjectBasicImplementation.getSocketAddress()
        );
    }

    @Override
    public void setState(String state) {
        this.state = state;
        TimoCloudBungee.getInstance().getSocketMessageManager().sendMessage("SET_STATE", getToken(), state);
    }

    @Override
    public void setExtra(String extra) {
        this.extra = extra;
        TimoCloudBungee.getInstance().getSocketMessageManager().sendMessage("SET_EXTRA", getToken(), extra);
    }

    @Override
    public void executeCommand(String command) {
        TimoCloudBungee.getInstance().getSocketMessageManager().sendMessage("EXECUTE_COMMAND", getToken(), command);
    }

    @Override
    public void stop() {
        TimoCloudBungee.getInstance().getSocketMessageManager().sendMessage("STOP_SERVER", getToken(), "");
    }

}
