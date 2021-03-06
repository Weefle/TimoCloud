package cloud.timo.TimoCloud.api.implementations;

import cloud.timo.TimoCloud.api.objects.CordObject;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class CordObjectBasicImplementation implements CordObject {

    private String name;
    private InetSocketAddress address;
    private boolean connected;

    public CordObjectBasicImplementation() {}

    public CordObjectBasicImplementation(String name, InetSocketAddress address, boolean connected) {
        this.name = name;
        this.address = address;
        this.connected = connected;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InetSocketAddress getSocketAddress() {
        return address;
    }

    @Override
    public InetAddress getIpAddress() {
        return getSocketAddress().getAddress();
    }

    @Override
    public int getPort() {
        return getSocketAddress().getPort();
    }

    @Override
    public boolean isConnected() {
        return connected;
    }
}
