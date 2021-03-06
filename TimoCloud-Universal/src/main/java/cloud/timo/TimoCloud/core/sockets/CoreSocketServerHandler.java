package cloud.timo.TimoCloud.core.sockets;

import cloud.timo.TimoCloud.core.TimoCloudCore;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

@ChannelHandler.Sharable
public class CoreSocketServerHandler extends ChannelInboundHandlerAdapter {

    private Map<Channel, Communicatable> communicatables;

    public CoreSocketServerHandler() {
        communicatables = new HashMap<>();
    }

    public void sendMessage(Channel channel, String type, Object data) {
        sendMessage(channel, TimoCloudCore.getInstance().getSocketMessageManager().getMessage(type, data));
    }

    public void sendMessage(Channel channel, String target, String type, Object data) {
        sendMessage(channel, TimoCloudCore.getInstance().getSocketMessageManager().getJSON(type, target, data));
    }

    public void sendMessage(Channel channel, JSONObject json) {
        if (channel != null && channel.isActive()) channel.writeAndFlush(json.toString());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        Communicatable communicatable = getCommunicatable(channel);
        removeChannel(channel);
        if (communicatable == null) return;
        communicatable.onDisconnect();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    public void removeChannel(Channel channel) {
        if (communicatables.containsKey(channel)) communicatables.remove(channel);
    }

    public Communicatable getCommunicatable(Channel channel) {
        return communicatables.get(channel);
    }

    public void setCommunicatable(Channel channel, Communicatable communicatable) {
        communicatables.put(channel, communicatable);
    }

}